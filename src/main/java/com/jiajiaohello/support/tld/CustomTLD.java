package com.jiajiaohello.support.tld;


import org.apache.commons.beanutils.BeanPropertyValueEqualsPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.functors.EqualPredicate;

import java.util.Collection;

/**
 * User: bohan
 * Date: 11/13/14
 * Time: 3:18 PM
 */
public class CustomTLD {
    public static boolean contains(Collection collection, Object o) {
        return CollectionUtils.exists(collection, new EqualPredicate(o));
    }

    public static boolean containsProperty(Collection collection, String propertyName, Object o) {
        return CollectionUtils.exists(collection, new BeanPropertyValueEqualsPredicate(propertyName, o));
    }
}
