package ch.frankel.kubernetes.extend;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sidecar {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sidecar.class);

    public static void main(String[] args) {
        LOGGER.info("*** JVM Operator v1.13 ***");
        DefaultKubernetesClient client = new DefaultKubernetesClient();
        client.pods().inNamespace(SidecarWatcher.NAMESPACE)
                .watch(new SidecarWatcher(client));
    }
}