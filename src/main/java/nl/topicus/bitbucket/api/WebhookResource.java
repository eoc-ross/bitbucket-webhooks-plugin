package nl.topicus.bitbucket.api;

import com.atlassian.bitbucket.repository.Repository;
import com.atlassian.bitbucket.rest.util.ResourcePatterns;
import nl.topicus.bitbucket.persistence.WebHookConfiguration;
import nl.topicus.bitbucket.persistence.WebHookConfigurationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Path(ResourcePatterns.REPOSITORY_URI + "/configurations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WebhookResource {

    private final WebHookConfigurationDao webHookConfigurationDao;

    @Autowired
    public WebhookResource(WebHookConfigurationDao webHookConfigurationDao) {
        this.webHookConfigurationDao = webHookConfigurationDao;
    }

    @GET
    public List<WebHookConfigurationModel> getWebhooks(@Context Repository repo) {
        return Arrays.stream(webHookConfigurationDao.getWebHookConfigurations(repo))
                .map(WebHookConfigurationModel::new)
                .collect(Collectors.toList());
    }

    @POST
    public WebHookConfigurationModel createWebhook(@Context Repository repo, WebHookConfigurationModel newWebhook) {
        return createOrUpdateWebhook(repo, null, newWebhook);
    }

    //PUT method for a create action is incorrect, but is kept for backwards compatibility
    @PUT
    public WebHookConfigurationModel createWebhookPUT(@Context Repository repo, WebHookConfigurationModel newWebhook) {
        return createOrUpdateWebhook(repo, null, newWebhook);
    }

    @Path("/{configId}")
    @PUT
    public WebHookConfigurationModel updateWebhook(@Context Repository repo, @PathParam("configId") String configId,
                                                   WebHookConfigurationModel updatedWebhook) {
        return createOrUpdateWebhook(repo, configId, updatedWebhook);
    }

    //POST method for an update action is incorrect, but is kept for backwards compatibility
    @Path("/{configId}")
    @POST
    public WebHookConfigurationModel updateWebhookPOST(@Context Repository repo, @PathParam("configId") String configId,
                                                   WebHookConfigurationModel updatedWebhook) {
        return createOrUpdateWebhook(repo, configId, updatedWebhook);
    }

    @Path("/{configId}")
    @DELETE
    public void removeWebhook(@Context Repository repo, @PathParam("configId") String configId) {
        WebHookConfiguration webhookCOnfiguration = webHookConfigurationDao.getWebHookConfiguration(configId);
        if (webhookCOnfiguration == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Webhook not found")
                    .build());
        }
        if (webhookCOnfiguration.getRepositoryId().equals(repo.getId())) {
            webHookConfigurationDao.deleteWebhookConfiguration(webhookCOnfiguration);
        }
    }

    private WebHookConfigurationModel createOrUpdateWebhook(Repository repo, String configId,
                                                            WebHookConfigurationModel updatedWebhook) {
        WebHookConfiguration createdWebhook = webHookConfigurationDao.createOrUpdateWebHookConfiguration(
                repo, configId, updatedWebhook.getTitle(), updatedWebhook.getUrl(), updatedWebhook.getCommittersToIgnore(),
                updatedWebhook.getBranchesToIgnore(), updatedWebhook.isEnabled(), updatedWebhook.isTagCreated(),
                updatedWebhook.isBranchDeleted(), updatedWebhook.isBranchCreated(), updatedWebhook.isRepoPush(),
                updatedWebhook.isPrDeclined(), updatedWebhook.isPrRescoped(), updatedWebhook.isPrMerged(),
                updatedWebhook.isPrReopened(), updatedWebhook.isPrUpdated(), updatedWebhook.isPrCreated(),
                updatedWebhook.isPrCommented(), updatedWebhook.isBuildStatus());

        return new WebHookConfigurationModel(createdWebhook);
    }
}
