/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2020-2021 Andres Almiray.
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
package org.jreleaser.config.yaml;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.jreleaser.config.JReleaserConfigParser;
import org.jreleaser.model.JReleaserModel;
import org.kordamp.jipsy.annotations.ServiceProviderFor;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Map;

/**
 * @author Andres Almiray
 * @since 0.1.0
 */
@ServiceProviderFor(JReleaserConfigParser.class)
public class YamlJReleaserConfigParser implements JReleaserConfigParser {
    @Override
    public String getPreferredFileExtension() {
        return "yml";
    }

    @Override
    public boolean supports(Path configFile) {
        String fileName = configFile.getFileName().toString();
        return fileName.endsWith(".yml") || fileName.endsWith(".yaml");
    }

    @Override
    public JReleaserModel parse(InputStream inputStream) throws IOException {
        YAMLMapper mapper = YAMLMapper.builder().build();
        return mapper.readValue(inputStream, JReleaserModel.class);
    }

    @Override
    public Map<String, String> properties(InputStream inputStream) throws IOException {
        YAMLMapper mapper = YAMLMapper.builder().build();
        return mapper.readValue(inputStream, Map.class);
    }
}
