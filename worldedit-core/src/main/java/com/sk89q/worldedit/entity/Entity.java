/*
 * WorldEdit, a Minecraft world manipulation toolkit
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldEdit team and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit.entity;

import com.sk89q.worldedit.extension.platform.Locatable;
import com.sk89q.worldedit.extent.Extent;
import com.sk89q.worldedit.util.Faceted;

import javax.annotation.Nullable;

/**
 * A reference to an instance of an entity that exists in an {@link Extent}
 * and thus would have position and similar details.
 *
 * <p>This object cannot be directly cloned because it represents a particular
 * instance of an entity, but a {@link BaseEntity} can be created from
 * this entity by calling {@link #getState()}.</p>
 */
public interface Entity extends Faceted, Locatable {

    /**
     * Get a copy of the entity's state.
     *
     * <p>In some cases, this method may return {@code null} if a snapshot
     * of the entity can't be created. It may not be possible, for example,
     * to get a snapshot of a player.</p>
     *
     * @return the entity's state or null if one cannot be created
     */
    @Nullable
    BaseEntity getState();

    /**
     * Remove this entity from it container.
     *
     * @return true if removal was successful
     */
    boolean remove();

    /**
     * Schedules a task.
     *
     * @see com.sk89q.worldedit.extension.platform.scheduler.SchedulerAdapter
     * @param runnable The task to execute.
     */
    default void executeAtEntity(Runnable runnable) {
        throw new UnsupportedOperationException("Not implemented in this platform");
    }

    /**
     * Schedules a task with the given delay.
     *
     * @see com.sk89q.worldedit.extension.platform.scheduler.SchedulerAdapter
     * @param runnable The task to execute.
     * @param delay    The time delay to pass before the task should be executed, in ticks.
     */
    default void runAtEntityDelayed(Runnable runnable, long delay) {
        throw new UnsupportedOperationException("Not implemented in this platform");
    }
}
