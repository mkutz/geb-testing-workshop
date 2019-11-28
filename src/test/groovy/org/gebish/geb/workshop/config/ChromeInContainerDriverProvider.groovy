package org.gebish.geb.workshop.config

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.testcontainers.containers.BrowserWebDriverContainer
import org.testcontainers.containers.GenericContainer

class ChromeInContainerDriverProvider {

    static WebDriver create() {
        def container = new BrowserWebDriverContainer<>()
            .withCapabilities(new ChromeOptions())

        container.start()
        addContainerToNetwork(container, "geb-testing-workshop")
        container.webDriver
    }

    private static void addContainerToNetwork(GenericContainer container, String networkName) {
        def network = container.dockerClient.listNetworksCmd()
            .withNameFilter(networkName)
            .exec()
            .first()

        container.dockerClient.connectToNetworkCmd()
            .withContainerId(container.containerId)
            .withNetworkId(network.id)
            .exec()
    }
}
