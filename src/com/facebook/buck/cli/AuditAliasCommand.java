/*
 * Copyright 2015-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.cli;

import java.io.IOException;

public class AuditAliasCommand extends AbstractCommandRunner<AuditAliasCommandOptions> {

  public AuditAliasCommand(CommandRunnerParams params) {
    super(params);
  }

  @Override
  String getUsageIntro() {
    return "Query information about the [alias] list in .buckconfig.";
  }

  @Override
  AuditAliasCommandOptions createOptions(BuckConfig buckConfig) {
    return new AuditAliasCommandOptions(buckConfig);
  }

  @Override
  int runCommandWithOptionsInternal(AuditAliasCommandOptions options)
      throws IOException, InterruptedException {
    if (options.isListAliases()) {
      for (String alias : options.getAliases()) {
        console.getStdOut().println(alias);
      }
      return 0;
    }

    console.getStdErr().println("No query supplied.");
    return 1;
  }
}
