#!/bin/bash
#
# Copyright (c) 2015 the authors of j2objc-gradle (see AUTHORS file)
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

set -euv

# What Java versions do we have?
/usr/libexec/java_home -V

# Prep brew itself
brew update
brew outdated caskroom/cask/brew-cask || brew upgrade caskroom/cask/brew-cask

# We must be able to get older Java versions than the latest.
brew tap caskroom/versions
sudo rm -rf /Library/Java/JavaVirtualMachines
brew cask install java

# Fail unless we installed JDK 8 correctly.
/usr/libexec/java_home --failfast --version 1.8
