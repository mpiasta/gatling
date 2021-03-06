/*
 * Copyright 2011-2020 GatlingCorp (https://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.gatling.commons.util

object Maps {

  @deprecated("Will be removed once FrontLine stop supporting Gatling 3.4", "3.5.0")
  implicit class PimpedMap[K, V](val map: Map[K, V]) extends AnyVal {

    def forceMapValues[V2](f: V => V2): Map[K, V2] =
      if (map.isEmpty) {
        Map.empty
      } else {
        map.map { case (k, v) => k -> f(v) }
      }
  }
}
