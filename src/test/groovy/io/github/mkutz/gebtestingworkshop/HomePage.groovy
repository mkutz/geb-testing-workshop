package io.github.mkutz.gebtestingworkshop

import geb.Page

class HomePage extends Page {

    static url = "/"

    static at = { $(".feed-toggle") }
}
