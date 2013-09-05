/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.filter;

import org.xwiki.component.annotation.Role;
import org.xwiki.stability.Unstable;

/**
 * Manager {@link FilterDescriptor} related to classes.
 * 
 * @version $Id$
 * @since 5.2M1
 */
@Role
@Unstable
public interface FilterDescriptorManager
{
    /**
     * @param type the filter class
     * @return the filter descriptor
     */
    FilterDescriptor getFilterDescriptor(Class< ? > type);

    /**
     * Helper for input module taking care of calling the right event when it exist, fallback on {@link UnknownFilter}
     * or simply ignores it when the filter does not support it.
     * 
     * @param <F> the class of the filter
     * @param filterClass the class of the filter
     * @param targetFilter the actual filter to send events to
     * @return the filter proxy
     */
    <F> F createFilterProxy(Class<F> filterClass, Object targetFilter);
}