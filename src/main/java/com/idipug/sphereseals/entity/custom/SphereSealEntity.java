package com.idipug.sphereseals.entity.custom;

import com.idipug.sphereseals.entity.ModEntities;
import com.idipug.sphereseals.sounds.ModSounds;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class SphereSealEntity extends AnimalEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState petAnimationState = new AnimationState();
    public final AnimationState clapAnimationState = new AnimationState();
    public final AnimationState rollAnimationState = new AnimationState();
    public final AnimationState waddleAnimationState = new AnimationState();

    private int idleAnimationTimeout = 0;
    public int petTicks = 0;
    private int clapTicks = 0;
    public int rollTicks = 0;

    public int getRollTicks() { return rollTicks; }

    public SphereSealEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 0;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 2));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(3, new TemptGoal(this, 1.25D, Ingredient.ofItems( Items.SALMON), false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 14)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.2F)
                .add(EntityAttributes.FOLLOW_RANGE, 20)
                .add(EntityAttributes.TEMPT_RANGE, 12);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.getEntityWorld().isClient()) return;


        if (petTicks > 0) {
            petTicks--;
            if (petTicks == 0) petAnimationState.stop();
        }



        if (clapTicks > 0) {
            clapTicks--;
            if (clapTicks == 0) clapAnimationState.stop();
        }


        double speed = this.getVelocity().horizontalLength();
        if (speed > 0.05D) {
            if (!rollAnimationState.isRunning()) {
                rollAnimationState.start(this.age);
                rollTicks = 20;
            }
        }

        if (rollTicks > 0) {
            rollTicks--;
            if (rollTicks == 0) rollAnimationState.stop();
        }

        if (speed > 0.02D
                && !rollAnimationState.isRunning()
                && !clapAnimationState.isRunning()
                && !petAnimationState.isRunning()) {

            if (!waddleAnimationState.isRunning()) {
                waddleAnimationState.start(this.age);
            }
        } else {
            waddleAnimationState.stop();
        }

        if (!petAnimationState.isRunning()
                && !clapAnimationState.isRunning()
                && !rollAnimationState.isRunning()
                && !waddleAnimationState.isRunning()
                && !idleAnimationState.isRunning()) {
            idleAnimationState.start(this.age);
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.SALMON);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.SPHERE_SEAL.create(world, SpawnReason.BREEDING);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);


        if (stack.isEmpty()) {

            if (!this.getEntityWorld().isClient()) {
                this.playSound(
                        ModSounds.SPHERE_SEAL_PET,
                        0.4F,
                        0.9F + this.random.nextFloat() * 0.2F
                );
            }

            if (this.getEntityWorld().isClient()) {
                petTicks = 60;
                petAnimationState.start(this.age);
            }

            return ActionResult.SUCCESS;
        }

        if (stack.isOf(Items.SALMON) && this.getEntityWorld().isClient()) {
            this.clapAnimationState.start(this.age);
            this.clapTicks = 45;
            return ActionResult.SUCCESS;
        }

        if (!this.getEntityWorld().isClient()) {
            this.playSound(
                    ModSounds.SPHERE_SEAL_CLAP,
                    5.0F,
                    0.9F + this.random.nextFloat() * 0.2F
            );
        }

        return super.interactMob(player, hand);
    }


    @Override
    protected void eat(PlayerEntity player, Hand hand, ItemStack stack) {
        super.eat(player, hand, stack);

        if (!this.getEntityWorld().isClient()) {
            this.playSound(
                    ModSounds.SPHERE_SEAL_CLAP,
                    5.0F,
                    0.9F + this.random.nextFloat() * 0.2F
            );
        }


        if (this.getEntityWorld().isClient()) {
            clapTicks = 45;
            clapAnimationState.start(this.age);
        }
    }



    @Override
    protected void playHurtSound(DamageSource source) {
        this.playSound(
                ModSounds.SPHERE_SEAL_HURT,
                3F,
                1.0F
        );
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return ModSounds.SPHERE_SEAL_IDLE;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.SPHERE_SEAL_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return ModSounds.SPHERE_SEAL_HURT;
    }


    @Override
    protected float getSoundVolume() {
        return 0.5F;
    }
}
