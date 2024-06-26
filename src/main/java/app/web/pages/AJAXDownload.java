package app.web.pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.AbstractAjaxBehavior;
import org.apache.wicket.request.handler.resource.ResourceStreamRequestHandler;
import org.apache.wicket.request.resource.ContentDisposition;
import org.apache.wicket.util.resource.IResourceStream;

/**
 * AJAXDownload is a class that allows for downloading files via AJAX.
 */
public abstract class AJAXDownload extends AbstractAjaxBehavior {
  public AJAXDownload() {

  }

  public void initiate(AjaxRequestTarget target) {
    String url = getCallbackUrl().toString();
    url = url + (url.contains("?") ? "&" : "?");
    url = url + "antiCache=" + System.currentTimeMillis();
    target.appendJavaScript("setTimeout(\"window.location.href='" + url + "'\", 100);");
  }

  public void onRequest() {
    ResourceStreamRequestHandler handler = new ResourceStreamRequestHandler(getResourceStream(), getFileName());
    handler.setContentDisposition(ContentDisposition.ATTACHMENT);
    getComponent().getRequestCycle().scheduleRequestHandlerAfterCurrent(handler);
  }

  protected String getFileName() {
    return null;
  }

  protected abstract IResourceStream getResourceStream();
}
