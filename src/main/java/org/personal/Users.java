package org.personal;

import org.personal.helpers.JsonHelper;

public class Users {

    private static final JsonHelper jsonHelper= new JsonHelper();

    public static UserData alertFeedEnabled = jsonHelper.getUser("alertfeedenabled.atester");
}

