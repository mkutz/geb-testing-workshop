import org.openqa.selenium.chrome.ChromeOptions
import org.testcontainers.containers.BrowserWebDriverContainer

baseUrl = "https://react-redux.realworld.io/"

environments {
    testcontainers {
        driver = {
            def container = new BrowserWebDriverContainer<>()
                .withCapabilities(new ChromeOptions())

            container.start()
            container.webDriver
        }
    }
}