/*
 * Copyright (c) 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.api.client.http.xml.atom;

import com.google.api.client.http.xml.AbstractXmlHttpContent;
import com.google.api.client.xml.atom.Atom;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;

/**
 * Serializes Atom XML HTTP content based on the data key/value mapping object for an Atom feed.
 * <p>
 * Default value for {@link #contentType} is {@link Atom#CONTENT_TYPE}.
 * <p>
 * Sample usage:
 *
 * <pre>
 * <code>
  static void setContent(
      HttpRequest request, XmlNamespaceDictionary namespaceDictionary, Object feed) {
    AtomFeedContent content = new AtomFeedContent();
    content.namespaceDictionary = namespaceDictionary;
    content.feed = feed;
    request.content = content;
  }
 * </code>
 * </pre>
 *
 * @since 1.4
 * @author Yaniv Inbar
 */
public class AtomFeedContent extends AbstractXmlHttpContent {

  /** Key/value pair data for the Atom feed. */
  public Object feed;

  public AtomFeedContent() {
    contentType = Atom.CONTENT_TYPE;
  }

  @Override
  public final void writeTo(XmlSerializer serializer) throws IOException {
    namespaceDictionary.serialize(serializer, Atom.ATOM_NAMESPACE, "feed", feed);
  }
}
