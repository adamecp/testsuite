package org.jboss.hal.testsuite.creaper.command.logging;

import org.wildfly.extras.creaper.core.offline.OfflineCommand;
import org.wildfly.extras.creaper.core.online.OnlineCommand;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ivan Straka istraka@redhat.com
 */

public abstract class ManipulateLogCategory implements OnlineCommand, OfflineCommand {

    protected String category;
    protected Level level;
    protected List<String> handlers = null;
    protected Boolean useParentHandler = false;
    protected String filter;

    protected void setBaseProperties(Builder<AddLogCategory.Builder> builder) {
        category = builder.category;
        level = builder.level;
        handlers = builder.handlers;
        useParentHandler = builder.useParentHandler;
        filter = builder.filter;
    }

    public abstract static class Builder<THIS extends Builder> {

        protected final String category;
        protected Level level = null;
        protected List<String> handlers = null;
        protected boolean useParentHandler;
        protected String filter = null;

        public Builder(final String category) {
            if (category == null || category.equals("")) {
                throw new IllegalArgumentException("category can not be null, nor empty string");
            }
            this.category = category;
        }

        public THIS level(final Level level) {
            if (level == null) {
                throw new IllegalArgumentException("level can not be null");
            }
            this.level = level;
            return (THIS) this;
        }

        public THIS handler(final String handler) {
            if (handler == null) {
                throw new IllegalArgumentException("handler can not be null");
            }
            if (this.handlers == null) {
                initHandlers();
            }
            this.handlers.add(handler);
            return (THIS) this;
        }

        public THIS handlers(final String... handlers) {
            if (handlers == null) {
                throw new IllegalArgumentException("handlers can not be null");
            }
            if (this.handlers == null) {
                initHandlers();
            }
            this.handlers.addAll(Arrays.asList(handlers));
            return (THIS) this;
        }

        public THIS setUseParentHandler(final boolean option) {
            this.useParentHandler = option;
            return (THIS) this;
        }

        private void initHandlers() {
            this.handlers = new LinkedList<String>();
        }

        /**
         * For example match("a*").
         *
         * @param filter
         * @return
         */
        public THIS filter(final String filter) {
            if (filter == null) {
                throw new IllegalArgumentException("filter can not be null");
            }
            this.filter = filter;

            return (THIS) this;
        }

        public abstract ManipulateLogCategory build();
    }
}
