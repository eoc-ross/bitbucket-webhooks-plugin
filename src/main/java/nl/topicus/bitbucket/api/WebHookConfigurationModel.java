package nl.topicus.bitbucket.api;

import nl.topicus.bitbucket.persistence.WebHookConfiguration;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WebHookConfigurationModel {
    @XmlElement
    private Integer id;
    @XmlElement
    private String title;
    @XmlElement
    private String url;
    @XmlElement
    private String committersToIgnore;
    @XmlElement
    private String branchesToIgnore;
    @XmlElement
    private boolean enabled;
    @XmlElement
    private boolean tagCreated;
    @XmlElement
    private boolean branchDeleted;
    @XmlElement
    private boolean branchCreated;
    @XmlElement
    private boolean repoPush;
    @XmlElement
    private boolean prDeclined;
    @XmlElement
    private boolean prRescoped;
    @XmlElement
    private boolean prMerged;
    @XmlElement
    private boolean prReopened;
    @XmlElement
    private boolean prUpdated;
    @XmlElement
    private boolean prCreated;
    @XmlElement
    private boolean prCommented;
    @XmlElement
    private boolean buildStatus;

    WebHookConfigurationModel(WebHookConfiguration webHookConfiguration) {
        id = webHookConfiguration.getID();
        title = webHookConfiguration.getTitle();
        url = webHookConfiguration.getURL();
        committersToIgnore = webHookConfiguration.getCommittersToIgnore();
        branchesToIgnore = webHookConfiguration.getBranchesToIgnore();
        enabled = webHookConfiguration.isEnabled();
        tagCreated = webHookConfiguration.isTagCreated();
		branchDeleted = webHookConfiguration.isBranchDeleted();
		branchCreated = webHookConfiguration.isBranchCreated();
		repoPush = webHookConfiguration.isRepoPush();
		prDeclined = webHookConfiguration.isPrDeclined();
		prRescoped = webHookConfiguration.isPrRescoped();
		prMerged = webHookConfiguration.isPrMerged();
		prReopened = webHookConfiguration.isPrReopened();
		prUpdated = webHookConfiguration.isPrUpdated();
		prCreated = webHookConfiguration.isPrCreated();
		prCommented = webHookConfiguration.isPrCommented();
		buildStatus = webHookConfiguration.isBuildStatus();
    }

    public WebHookConfigurationModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCommittersToIgnore()
    {
        return committersToIgnore;
    }

    public void setCommittersToIgnore(String committersToIgnore)
    {
        this.committersToIgnore = committersToIgnore;
    }

    public String getBranchesToIgnore()
    {
        return branchesToIgnore;
    }

    public void setBranchesToIgnore(String branchesToIgnore)
    {
        this.branchesToIgnore = branchesToIgnore;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    @Override
    public String toString() {
        return "WebHookConfigurationModel{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", committersToIgnore='" + committersToIgnore + '\'' +
                ", branchesToIgnore='" + branchesToIgnore + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    public boolean isTagCreated() {
        return tagCreated;
    }

    public void setTagCreated(boolean tagCreated) {
        this.tagCreated = tagCreated;
    }

    public boolean isBranchDeleted() {
        return branchDeleted;
    }

    public void setBranchDeleted(boolean branchDeleted) {
        this.branchDeleted = branchDeleted;
    }

    public boolean isBranchCreated() {
        return branchCreated;
    }

    public void setBranchCreated(boolean branchCreated) {
        this.branchCreated = branchCreated;
    }

    public boolean isRepoPush() {
        return repoPush;
    }

    public void setRepoPush(boolean repoPush) {
        this.repoPush = repoPush;
    }

    public boolean isPrDeclined() {
        return prDeclined;
    }

    public void setPrDeclined(boolean prDeclined) {
        this.prDeclined = prDeclined;
    }

    public boolean isPrRescoped() {
        return prRescoped;
    }

    public void setPrRescoped(boolean prRescoped) {
        this.prRescoped = prRescoped;
    }

    public boolean isPrMerged() {
        return prMerged;
    }

    public void setPrMerged(boolean prMerged) {
        this.prMerged = prMerged;
    }

    public boolean isPrReopened() {
        return prReopened;
    }

    public void setPrReopened(boolean prReopened) {
        this.prReopened = prReopened;
    }

    public boolean isPrUpdated() {
        return prUpdated;
    }

    public void setPrUpdated(boolean prUpdated) {
        this.prUpdated = prUpdated;
    }

    public boolean isPrCreated() {
        return prCreated;
    }

    public void setPrCreated(boolean prCreated) {
        this.prCreated = prCreated;
    }

    public boolean isPrCommented() {
        return prCommented;
    }

    public void setPrCommented(boolean prCommented) {
        this.prCommented = prCommented;
    }

    public boolean isBuildStatus() {
        return buildStatus;
    }

    public void setBuildStatus(boolean buildStatus) {
        this.buildStatus = buildStatus;
    }
}
