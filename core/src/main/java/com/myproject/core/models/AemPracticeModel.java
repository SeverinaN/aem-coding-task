package com.myproject.core.models;

import java.util.List;

public interface AemPracticeModel {

    String getImagePath();

    String getTitle();

    boolean isBackground();

    List<NavigationItem> getNavigationItems();
}
