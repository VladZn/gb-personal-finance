package ru.gd.dev.spring.pfs.ui.view.content.fragment;

import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.html.Div;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @autor Eremin Artem on 24.02.2019.
 */

public class CircleChartBox extends Div {

    public CircleChartBox() {
        getClassNames().add("circleChartBox");
        getClassNames().add("accountsChartBox");
        Map<String, BigDecimal> accounts = new HashMap<>();
        final ChartWithLegend chartWithLegend = new ChartWithLegend(
                ChartType.PIE,
                "Статистика по счетам",
                accounts
        );
        add(chartWithLegend);
    }


}
