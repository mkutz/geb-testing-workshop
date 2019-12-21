package io.github.mkutz.gebtestingworkshop

import geb.Module

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ArticlePreviewModule extends Module {

    final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("EEE MMM dd yyyy").withLocale(Locale.ENGLISH)

    static content = {
        title { $("h1") }
        author { $(".author") }
        date { $(".date") }
    }

    LocalDate getLocalDate() {
        return LocalDate.parse(date.text(), DATE_FORMAT)
    }
}
