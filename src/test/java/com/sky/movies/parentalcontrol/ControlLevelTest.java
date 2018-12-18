package com.sky.movies.parentalcontrol;

import org.junit.Test;

import static com.sky.movies.parentalcontrol.ControlLevel.*;
import static com.sky.movies.parentalcontrol.ControlLevel.AGE_18;
import static com.sky.movies.parentalcontrol.ControlLevel.PG;
import static com.sky.movies.parentalcontrol.ControlLevel.U;
import static org.assertj.core.api.Assertions.assertThat;

public class ControlLevelTest {

    @Test
    public void canWatch() {
        assertThat(U.canWatch(PG)).isFalse();
        assertThat(PG.canWatch(AGE_18)).isFalse();
        assertThat(AGE_12.canWatch(AGE_15)).isFalse();
        assertThat(AGE_15.canWatch(AGE_18)).isFalse();

        assertThat(PG.canWatch(U)).isTrue();
        assertThat(AGE_12.canWatch(U)).isTrue();
        assertThat(AGE_15.canWatch(AGE_15)).isTrue();
        assertThat(AGE_15.canWatch(PG)).isTrue();
        assertThat(AGE_18.canWatch(AGE_18)).isTrue();
    }

    @Test
    public void resolve() {
        assertThat(ControlLevel.resolve("18")).isEqualTo(ControlLevel.AGE_18);
        assertThat(ControlLevel.resolve("PG")).isEqualTo(ControlLevel.PG);
        assertThat(ControlLevel.resolve("20")).isNull();
        assertThat(ControlLevel.resolve("")).isNull();
        assertThat(ControlLevel.resolve(null)).isNull();
    }
}