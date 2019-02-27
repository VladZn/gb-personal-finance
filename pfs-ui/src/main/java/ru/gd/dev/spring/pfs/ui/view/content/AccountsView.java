package ru.gd.dev.spring.pfs.ui.view.content;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import ru.gd.dev.spring.pfs.ui.dto.AccountDto;
import ru.gd.dev.spring.pfs.ui.view.content.fragment.AccountBox;
import ru.gd.dev.spring.pfs.ui.view.content.fragment.CircleChartBox;
import ru.gd.dev.spring.pfs.ui.view.menu.MenuView;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor Eremin Artem on 24.02.2019.
 */

@UIScope
@SpringComponent
@Route(value = "accounts", layout = MenuView.class)
public class AccountsView extends VerticalLayout {

    @NotNull
    private MessageSource messageSource;

    @Autowired
    public AccountsView(@NotNull final MessageSource messageSource) {
        final CircleChartBox circleChartBox = new CircleChartBox();
        final List<AccountDto> accounts = getAccounts();
        getClassNames().add("contentView");
        getClassNames().add("accountView");
        this.messageSource = messageSource;
        final Label title =
                new Label(messageSource.getMessage("menu.links.account", null, getLocale()));
        title.setId("accountLabel");
        title.getClassNames().add("pageTitle");
        add(title);
        add(circleChartBox);
        final Button button =
                new Button(messageSource.getMessage("account.button.add", null, getLocale()));
        button.addClickListener(e -> button.getUI().ifPresent(ui -> ui.navigate("createAccount")));
        button.getClassNames().add("button");
        button.getClassNames().add("createAccountButton");
        add(button);
        for (final AccountDto account : accounts) {
            add(new AccountBox(account));
        }
    }

    private List<AccountDto> getAccounts() {
        return new ArrayList<>();
    }
}
