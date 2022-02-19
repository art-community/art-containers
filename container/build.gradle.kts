/*
 * ART
 *
 * Copyright 2019-2022 ART
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

art {
    modules {
        embedded {
            kotlin {
                transport()
                logging()
                configurator()
                launcher()
                scheduler()
                tests()
                meta()
                yaml()
                http()
            }
        }
    }
    libraries {
        val lombokVersion: String by project
        graal()
        lombok(lombokVersion)
    }
    executable {
        main("io.art.linux.local.container.ContainerKt")
        native {
            wsl()
            static()
            disableGC()
        }
    }
    generator {
        source("Container") {
            jvm()
            modulePackage("io.art.linux.local.container")
            sourcesPattern {
                include("**/src/main/kotlin/**")
            }
        }
    }
    sources {
        lxc(static = true) {
        }
    }
}
