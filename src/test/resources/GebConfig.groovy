import org.openqa.selenium.chrome.ChromeOptions
import org.testcontainers.containers.BrowserWebDriverContainer
import org.testcontainers.containers.GenericContainer

baseUrl = "http://localhost:5000/"

environments {
    testcontainers {
        baseUrl = "http://frontend:5000/"

        driver = {
            def container = new BrowserWebDriverContainer<>()
                .withCapabilities(new ChromeOptions())

            container.start()
            addContainerToNetwork(container, "geb-testing-workshop")
            container.webDriver
        }
    }
}

void addContainerToNetwork(GenericContainer container, String networkName) {
    def network = container.dockerClient.listNetworksCmd()
        .withNameFilter(networkName)
        .exec()
        .first()

    container.dockerClient.connectToNetworkCmd()
        .withContainerId(container.containerId)
        .withNetworkId(network.id)
        .exec()
}