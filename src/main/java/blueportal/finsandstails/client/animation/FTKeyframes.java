package blueportal.finsandstails.client.animation;

import net.minecraft.util.Mth;

public class FTKeyframes {
    public enum Easing {
        LINEAR,
        EASE_IN_OUT_QUAD,
        EASE_IN_OUT_SINE
    }

    public static float ease(Easing easing, float f) {
        return switch (easing) {
            case EASE_IN_OUT_QUAD -> f < 0.5F ? 2.0F * f * f : 1.0F - ((-2.0F * f + 2.0F) * (-2.0F * f + 2.0F)) / 2.0F;
            case EASE_IN_OUT_SINE -> -(Mth.cos((float) Math.PI * f) - 1.0F) / 2.0F;
            default -> f;
        };
    }

    public static float keyframe(float time, float[] times, float[] values, Easing[] easings) {
        int last = times.length - 1;
        if (time <= times[0]) return values[0];
        if (time >= times[last]) return values[last];
        for (int i = 0; i < last; i++) {
            if (time < times[i + 1]) {
                float f = (time - times[i]) / (times[i + 1] - times[i]);
                return Mth.lerp(ease(easings[i], f), values[i], values[i + 1]);
            }
        }
        return values[last];
    }
}
