package org.jboss.hal.testsuite.page.config;

import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.Location;
import org.jboss.hal.testsuite.fragment.config.resourceadapters.ResourceAdaptersConfigArea;
import org.jboss.hal.testsuite.fragment.config.resourceadapters.ResourceAdaptersFragment;
import org.jboss.hal.testsuite.util.PropUtils;
import org.openqa.selenium.By;

/**
 * @author mkrajcov <mkrajcov@redhat.com>
 */
@Location("#profile")
public class ResourceAdaptersPage extends ConfigurationPage {

    private static final By CONTENT = By.id(PropUtils.get("page.content.id"));

    public ResourceAdaptersFragment getContent() {
        return Graphene.createPageFragment(ResourceAdaptersFragment.class, getContentRoot().findElement(CONTENT));
    }

    public ResourceAdaptersConfigArea getConfigArea() {
        return getConfig(ResourceAdaptersConfigArea.class);
    }
}
