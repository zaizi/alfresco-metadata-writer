package org.redpill.alfresco.module.metadatawriter.services.docx4j;

import java.io.IOException;
import java.util.Date;

import org.redpill.alfresco.module.metadatawriter.services.ContentFacade.ContentException;

public interface Docx4jFacade {

  void writeProperties() throws IOException;

  void setTitle(String title) throws ContentException;

  void setAuthor(String author) throws ContentException;

  void setKeywords(String keywords) throws ContentException;

  void setCreateDateTime(Date dateTime) throws ContentException;

  void setCustomMetadata(String field, String value) throws ContentException;

  void close() throws IOException;

}
