package org.redpill.alfresco.module.metadatawriter.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.alfresco.repo.content.MimetypeMap;
import org.alfresco.service.cmr.repository.ContentReader;
import org.alfresco.service.cmr.repository.ContentWriter;
import org.redpill.alfresco.module.metadatawriter.services.ContentFacade;
import org.redpill.alfresco.module.metadatawriter.services.MetadataContentInstantiator;
import org.redpill.alfresco.module.metadatawriter.services.poix.impl.POIXContentFacade;

public class POIXContentInstantiator {

  public static abstract class AbstractMSWordContentInstantiator implements MetadataContentInstantiator {

    @Override
    public ContentFacade create(InputStream inputStream, OutputStream outputStream) throws IOException {
      return new POIXContentFacade(inputStream, outputStream);
    }

    @Override
    public ContentFacade create(ContentReader reader, ContentWriter writer) throws IOException {
      return create(reader.getContentInputStream(), writer.getContentOutputStream());
    }

  }

  // ---------------------------------------------------
  // Public classes
  // ---------------------------------------------------
  public static class MSWordContentInstantiator extends AbstractMSWordContentInstantiator {

    @Override
    public boolean supports(String mimetype) {
      return MimetypeMap.MIMETYPE_OPENXML_WORDPROCESSING.equalsIgnoreCase(mimetype);
    }

  }

  public static class MSExcelContentInstantiator extends AbstractMSWordContentInstantiator {

    @Override
    public boolean supports(String mimetype) {
      return MimetypeMap.MIMETYPE_OPENXML_SPREADSHEET.equalsIgnoreCase(mimetype);
    }

  }

  public static class MSPowerPointContentInstantiator extends AbstractMSWordContentInstantiator {

    @Override
    public boolean supports(String mimetype) {
      return MimetypeMap.MIMETYPE_OPENXML_PRESENTATION.equalsIgnoreCase(mimetype);
    }

  }

}
