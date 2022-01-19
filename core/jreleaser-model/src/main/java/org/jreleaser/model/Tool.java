/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2020-2022 The JReleaser authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jreleaser.model;

import java.util.List;
import java.util.Set;

/**
 * @author Andres Almiray
 * @since 0.1.0
 */
public interface Tool extends Domain, ExtraProperties, Activatable {
    String getName();

    String getDownloadUrl();

    void setDownloadUrl(String downloadUrl);

    boolean supportsPlatform(String platform);

    boolean supportsDistribution(Distribution distribution);

    Set<String> getSupportedExtensions(Distribution distribution);

    List<Artifact> resolveCandidateArtifacts(JReleaserContext context, Distribution distribution);

    boolean isSnapshotSupported();

    boolean isContinueOnError();

    void setContinueOnError(Boolean continueOnError);

    boolean isContinueOnErrorSet();

    boolean isFailed();

    void fail();
}
