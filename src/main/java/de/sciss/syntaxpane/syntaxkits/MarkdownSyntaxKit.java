/*
 * Copyright 2011-2022 Hanns Holger Rutz.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License
 *       at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.sciss.syntaxpane.syntaxkits;

import de.sciss.syntaxpane.DefaultSyntaxKit;
import de.sciss.syntaxpane.lexers.MarkdownLexer;

public class MarkdownSyntaxKit extends DefaultSyntaxKit {

    public MarkdownSyntaxKit() {
        super(new MarkdownLexer());
    }
}
