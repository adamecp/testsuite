/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2015, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
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

package org.jboss.hal.testsuite.finder;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.findby.ByJQuery;
import org.jboss.hal.testsuite.fragment.BaseFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by pjelinek on Aug 17, 2015
 */
public class PreviewFragment extends BaseFragment {

    public String getIncludedFromProfile() {
        By selector = ByJQuery.selector("h3:contains('Included from profile:')");
        Graphene.waitAjax().until().element(root, selector).is().visible();
        WebElement element = root.findElement(selector);
        // remove the 'Included from profile:' prefix
        return element.getText().substring(22).trim();
    }

    public List<String> getDisplayedUnorderedList() {
        By selector = ByJQuery.selector("ul li");
        Graphene.waitAjax().until().element(root, selector).is().visible();
        return root.findElements(selector).stream().filter(element -> element.isDisplayed()).map(element -> element.getText()).collect(toList());
    }

}
