package org.jboss.hal.testsuite.fragment.config.federation;

import org.jboss.hal.testsuite.fragment.ConfigAreaFragment;
import org.jboss.hal.testsuite.fragment.ConfigFragment;
import org.jboss.hal.testsuite.util.PropUtils;

/**
 * @author jcechace
 */
public class ServiceProviderConfigArea extends ConfigAreaFragment {
    public ConfigFragment attrsConfig() {
        String label = PropUtils.get("config.federation.sp.configarea.attrs.tab.label");
        return switchTo(label, ConfigFragment.class);
    }

    public ConfigFragment samlConfig() {
        String label = PropUtils.get("config.federation.sp.configarea.saml.tab.label");
        return switchTo(label, ConfigFragment.class);
    }
}
