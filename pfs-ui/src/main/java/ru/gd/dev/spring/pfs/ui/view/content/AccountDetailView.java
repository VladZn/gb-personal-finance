package ru.gd.dev.spring.pfs.ui.view.content;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import ru.gd.dev.spring.pfs.ui.view.menu.MenuView;

/**
 * @autor Eremin Artem on 24.02.2019.
 */

@Route(value = "account", layout = MenuView.class)
public class AccountDetailView extends VerticalLayout implements HasUrlParameter<String> {


    @Override
    public void setParameter(final BeforeEvent beforeEvent, @OptionalParameter final String parameter) {
    }

}
