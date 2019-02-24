package ru.gd.dev.spring.pfs.ui.view.content;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import ru.gd.dev.spring.pfs.ui.view.menu.MenuView;

/**
 * @autor Eremin Artem on 24.02.2019.
 */

@Route(value = "accounts", layout = MenuView.class)
@SpringComponent
@UIScope
public class AccountView extends VerticalLayout {

    private MessageSource messageSource;

    @Autowired
    public AccountView(final MessageSource messageSource) {
        getClassNames().add("contentView");
        getClassNames().add("accountView");
        this.messageSource = messageSource;
        final Label label =
                new Label(messageSource.getMessage("menu.links.account", null, getLocale()));
        label.setId("accountLabel");
        add(label);
    }
}
