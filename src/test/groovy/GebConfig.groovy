import org.gebish.geb.workshop.config.ChromeInContainerDriverProvider
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

baseUrl = "http://localhost:3000/"

environments {
    testcontainers {
        baseUrl = "http://frontend:3000/"

        driver = {
            ChromeInContainerDriverProvider.create()
        }
    }
    headless {
        driver = {
            def options = new ChromeOptions(headless: true)
            new ChromeDriver(options)
        }
    }
}