/*
 Copyright 2013-2015 Jason Leyba
 
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 
   http://www.apache.org/licenses/LICENSE-2.0
 
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package com.github.jsdossier;

import static com.github.jsdossier.testing.CompilerUtil.createSourceFile;
import static com.google.common.truth.Truth.assertThat;

import com.github.jsdossier.jscomp.NominalType2;
import com.github.jsdossier.proto.BaseProperty;
import com.github.jsdossier.proto.Comment;
import com.github.jsdossier.proto.Function;
import com.github.jsdossier.proto.Function.Detail;
import com.google.common.base.Predicate;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for extracting function information with a {@link TypeInspector}.
 */
@RunWith(JUnit4.class)
public class TypeInspectorStaticFunctionTest extends AbstractTypeInspectorTest {
  
  @Test
  public void returnsInfoOnStaticFunctions_constructor() {
    compile(
        "/** @constructor */",
        "function A() {}",
        "",
        "/**",
        " * Says hello.",
        " * @param {string} name The person to greet.",
        " * @return {string} A greeting.",
        " * @throws {Error} If the person does not exist.",
        " */",
        "A.sayHi = function(name) { return 'Hello, ' + name; };");

    NominalType2 a = typeRegistry.getType("A");
    TypeInspector.Report report = typeInspector.inspectType(a);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).containsExactly(
        Function.newBuilder()
            .setBase(BaseProperty.newBuilder()
                .setName("A.sayHi")
                .setSource(sourceFile("source/foo.js.src.html", 10))
                .setDescription(htmlComment("<p>Says hello.</p>\n")))
            .addParameter(Detail.newBuilder()
                .setName("name")
                .setType(stringTypeComment())
                .setDescription(htmlComment("<p>The person to greet.</p>\n")))
            .setReturn(Detail.newBuilder()
                .setType(stringTypeComment())
                .setDescription(htmlComment("<p>A greeting.</p>\n")))
            .addThrown(Detail.newBuilder()
                .setType(errorTypeComment())
                .setDescription(htmlComment("<p>If the person does not exist.</p>\n")))
            .build());
  }
  
  @Test
  public void returnsInfoOnStaticFunctions_interface() {
    compile(
        "/** @interface */",
        "function A() {}",
        "",
        "/**",
        " * Says hello.",
        " * @param {string} name The person to greet.",
        " * @return {string} A greeting.",
        " * @throws {Error} If the person does not exist.",
        " */",
        "A.sayHi = function(name) { return 'Hello, ' + name; };");

    NominalType2 a = typeRegistry.getType("A");
    TypeInspector.Report report = typeInspector.inspectType(a);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).containsExactly(
        Function.newBuilder()
            .setBase(BaseProperty.newBuilder()
                .setName("A.sayHi")
                .setSource(sourceFile("source/foo.js.src.html", 10))
                .setDescription(htmlComment("<p>Says hello.</p>\n")))
            .addParameter(Detail.newBuilder()
                .setName("name")
                .setType(stringTypeComment())
                .setDescription(htmlComment("<p>The person to greet.</p>\n")))
            .setReturn(Detail.newBuilder()
                .setType(stringTypeComment())
                .setDescription(htmlComment("<p>A greeting.</p>\n")))
            .addThrown(Detail.newBuilder()
                .setType(errorTypeComment())
                .setDescription(htmlComment("<p>If the person does not exist.</p>\n")))
            .build());
  }
  
  @Test
  public void returnsInfoOnStaticFunctions_enum() {
    compile(
        "/** @enum {string} */",
        "var Color = {RED: 'red'};",
        "",
        "/**",
        " * Darkens a color.",
        " * @param {!Color} c The color to darken.",
        " * @return {!Color} The darkened color.",
        " * @throws {Error} If the color cannot be darkened.",
        " */",
        "Color.darken = function(c) { return c; };");

    NominalType2 type = typeRegistry.getType("Color");
    TypeInspector.Report report = typeInspector.inspectType(type);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).containsExactly(
        Function.newBuilder()
            .setBase(BaseProperty.newBuilder()
                .setName("Color.darken")
                .setSource(sourceFile("source/foo.js.src.html", 10))
                .setDescription(htmlComment("<p>Darkens a color.</p>\n")))
            .addParameter(Detail.newBuilder()
                .setName("c")
                .setType(stringTypeComment())
                .setDescription(htmlComment("<p>The color to darken.</p>\n")))
            .setReturn(Detail.newBuilder()
                .setType(stringTypeComment())
                .setDescription(htmlComment("<p>The darkened color.</p>\n")))
            .addThrown(Detail.newBuilder()
                .setType(errorTypeComment())
                .setDescription(htmlComment("<p>If the color cannot be darkened.</p>\n")))
            .build());
  }
  
  @Test
  public void returnsInfoOnStaticFunctions_namespace() {
    compile(
        "goog.provide('Color');",
        "",
        "/**",
        " * Darkens a color.",
        " * @param {string} c The color to darken.",
        " * @return {string} The darkened color.",
        " * @throws {Error} If the color cannot be darkened.",
        " */",
        "Color.darken = function(c) { return c; };");

    NominalType2 type = typeRegistry.getType("Color");
    TypeInspector.Report report = typeInspector.inspectType(type);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).containsExactly(
        Function.newBuilder()
            .setBase(BaseProperty.newBuilder()
                .setName("darken")
                .setSource(sourceFile("source/foo.js.src.html", 9))
                .setDescription(htmlComment("<p>Darkens a color.</p>\n")))
            .addParameter(Detail.newBuilder()
                .setName("c")
                .setType(stringTypeComment())
                .setDescription(htmlComment("<p>The color to darken.</p>\n")))
            .setReturn(Detail.newBuilder()
                .setType(stringTypeComment())
                .setDescription(htmlComment("<p>The darkened color.</p>\n")))
            .addThrown(Detail.newBuilder()
                .setType(errorTypeComment())
                .setDescription(htmlComment("<p>If the color cannot be darkened.</p>\n")))
            .build());
  }

  @Test
  public void extractsFunctionTemplateTypeNames() {
    compile(
        "goog.provide('foo');",
        "",
        "/**",
        " * @param {TYPE} v A value.",
        " * @return {TYPE} The value.",
        " * @template TYPE",
        " */",
        "foo.bar = function(v) { return v;};");

    NominalType2 type = typeRegistry.getType("foo");
    TypeInspector.Report report = typeInspector.inspectType(type);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).containsExactly(
        Function.newBuilder()
            .setBase(BaseProperty.newBuilder()
                .setName("bar")
                .setSource(sourceFile("source/foo.js.src.html", 8))
                .setDescription(Comment.getDefaultInstance()))
            .addParameter(Detail.newBuilder()
                .setName("v")
                .setType(textComment("TYPE"))
                .setDescription(htmlComment("<p>A value.</p>\n")))
            .setReturn(Detail.newBuilder()
                .setType(textComment("TYPE"))
                .setDescription(htmlComment("<p>The value.</p>\n")))
            .addTemplateName("TYPE")
            .build());
  }

  @Test
  public void staticFunctionsCanLinkToOtherStaticFunctions_onSameType() {
    compile(
        "/** @constructor */",
        "function Clazz() {}",
        "",
        "/**",
        " * Link to {@link Clazz.bar}.",
        " */",
        "Clazz.foo = function() {};",
        "",
        "/**",
        " * Link to {@link Clazz.foo}.",
        " */",
        "Clazz.bar = function() {};");

    NominalType2 type = typeRegistry.getType("Clazz");
    TypeInspector.Report report = typeInspector.inspectType(type);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).containsExactly(
        Function.newBuilder()
            .setBase(BaseProperty.newBuilder()
                .setName("Clazz.foo")
                .setSource(sourceFile("source/foo.js.src.html", 7))
                .setDescription(htmlComment(
                    "<p>Link to <a href=\"Clazz.html#Clazz.bar\">" +
                        "<code>Clazz.bar</code></a>.</p>\n")))
            .build(),
        Function.newBuilder()
            .setBase(BaseProperty.newBuilder()
                .setName("Clazz.bar")
                .setSource(sourceFile("source/foo.js.src.html", 12))
                .setDescription(htmlComment(
                    "<p>Link to <a href=\"Clazz.html#Clazz.foo\">" +
                        "<code>Clazz.foo</code></a>.</p>\n")))
            .build());
  }

  @Test
  public void staticFunctionsCanLinkToOtherStaticFunctions_onOtherType() {
    compile(
        "/** @constructor */",
        "function Clazz() {}",
        "",
        "/**",
        " * Link to {@link OtherClazz.bar}.",
        " */",
        "Clazz.foo = function() {};",
        "",
        "/** @constructor */",
        "function OtherClazz() {}",
        "OtherClazz.bar = function() {};");

    NominalType2 type = typeRegistry.getType("Clazz");
    TypeInspector.Report report = typeInspector.inspectType(type);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).containsExactly(
        Function.newBuilder()
            .setBase(BaseProperty.newBuilder()
                .setName("Clazz.foo")
                .setSource(sourceFile("source/foo.js.src.html", 7))
                .setDescription(htmlComment(
                    "<p>Link to <a href=\"OtherClazz.html#OtherClazz.bar\">" +
                        "<code>OtherClazz.bar</code></a>.</p>\n")))
            .build());
  }

  @Test
  public void staticFunctionsCanLinkToInstanceMethods() {
    compile(
        "/** @constructor */",
        "function Clazz() {}",
        "",
        "/**",
        " * Link to {@link #bar}.",
        " */",
        "Clazz.foo = function() {};",
        "",
        "Clazz.prototype.bar = function() {};");

    NominalType2 type = typeRegistry.getType("Clazz");
    TypeInspector.Report report = typeInspector.inspectType(type);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).containsExactly(
        Function.newBuilder()
            .setBase(BaseProperty.newBuilder()
                .setName("Clazz.foo")
                .setSource(sourceFile("source/foo.js.src.html", 7))
                .setDescription(htmlComment(
                    "<p>Link to <a href=\"Clazz.html#bar\">" +
                        "<code>#bar</code></a>.</p>\n")))
            .build());
  }

  @Test
  public void doesNotIdentifyConstructorPropertyAsStaticFunction1() {
    compile(
        "/** @constructor */",
        "var One = function () {};",
        "",
        "/** @constructor */",
        "One.Two = function() {};");

    NominalType2 type = typeRegistry.getType("One");
    TypeInspector.Report report = typeInspector.inspectType(type);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).isEmpty();
  }

  @Test
  public void doesNotIdentifyConstructorPropertyAsStaticFunction2() {
    compile(
        "goog.provide('foo');",
        "",
        "/** @constructor */",
        "foo.One = function() {};");

    NominalType2 type = typeRegistry.getType("foo");
    TypeInspector.Report report = typeInspector.inspectType(type);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).isEmpty();
  }

  @Test
  public void doesNotIdentifyConstructorPropertyAsStaticFunction3() {
    guice.toBuilder()
        .setTypeNameFilter(new Predicate<String>() {
          @Override
          public boolean apply(String input) {
            return "foo.One".equals(input);
          }
        })
        .build()
        .createInjector()
        .injectMembers(this); 

    compile(
        "goog.provide('foo');",
        "",
        "/** @constructor */",
        "foo.One = function() {};",
        "",
        "/** @return {!foo.One} A new object. */",
        "foo.newOne = function() { return new foo.One; };");

    NominalType2 type = typeRegistry.getType("foo");
    TypeInspector.Report report = typeInspector.inspectType(type);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).containsExactly(
        Function.newBuilder()
            .setBase(BaseProperty.newBuilder()
                .setName("newOne")
                .setSource(sourceFile("source/foo.js.src.html", 7))
                .setDescription(Comment.getDefaultInstance()))
            .setReturn(Detail.newBuilder()
                .setDescription(htmlComment("<p>A new object.</p>\n"))
                .setType(textComment("foo.One")))
            .build());
  }

  @Test
  public void doesNotRecordConstructorCallAsStaticFunction() {
    compile(
        "/** @constructor */",
        "var One = function () {};",
        "",
        "/** @constructor @extends {One} */",
        "var Two = function() { One.call(this); };",
        "goog.inherits(Two, One);");

    NominalType2 type = typeRegistry.getType("One");
    TypeInspector.Report report = typeInspector.inspectType(type);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).isEmpty();
  }

  @Test
  public void doesNotRecordConstructorCallAsStaticFunction_es6_1() {
    compile(
        "class One {}",
        "",
        "/** @constructor @extends {One} */",
        "var Two = function() { One.call(this); };",
        "goog.inherits(Two, One);");

    NominalType2 type = typeRegistry.getType("One");
    TypeInspector.Report report = typeInspector.inspectType(type);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).isEmpty();
  }

  @Test
  public void doesNotRecordConstructorCallAsStaticFunction_es6_2() {
    compile(
        "class One {}",
        "",
        "class Two extends One {",
        "  constructor() {",
        "    super();",
        "    One.call(this);",
        "  }",
        "}");

    NominalType2 type = typeRegistry.getType("One");
    TypeInspector.Report report = typeInspector.inspectType(type);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).isEmpty();
  }
  
  @Test
  public void usesDocsFromModuleVarIfExportedInstanceHasNoDocs_nodeModule() {
    util.compile(fs.getPath("/src/modules/foo/bar.js"),
        "/** Hello, world! */",
        "function greet() {}",
        "exports.greet = greet");
    NominalType2 type = typeRegistry.getType("dossier$$module__$src$modules$foo$bar");
    TypeInspector.Report report = typeInspector.inspectType(type);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).containsExactly(
        Function.newBuilder()
            .setBase(BaseProperty.newBuilder()
                .setName("greet")
                .setSource(sourceFile("../source/modules/foo/bar.js.src.html", 3))
                .setDescription(htmlComment("<p>Hello, world!</p>\n")))
            .build());
  }
  
  @Test
  public void usesDocsFromModuleVarIfExportedInstanceHasNoDocs_es6Module() {
    util.compile(fs.getPath("/src/modules/foo/bar.js"),
        "/** Hello, world! */",
        "function greet() {}",
        "export {greet}");
    System.out.println(util.toSource());
    NominalType2 type = typeRegistry.getType("module$src$modules$foo$bar");
    Assume.assumeNotNull(type, "Update this test for new type registry which supports es6");
    TypeInspector.Report report = typeInspector.inspectType(type);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).containsExactly(
        Function.newBuilder()
            .setBase(BaseProperty.newBuilder()
                .setName("greet")
                .setSource(sourceFile("../source/modules/foo/bar.js.src.html", 3))
                .setDescription(htmlComment("<p>Hello, world!</p>\n")))
            .build());
  }

  @Test
  public void usesDocsFromModuleVarIfExportedInstanceHasNoDocs_nodeModuleForwardsExport() {
    util.compile(
        createSourceFile(
            fs.getPath("/src/modules/foo/bar.js"),
            "/** Hello, world! */",
            "function greet() {}",
            "exports.greet = greet"),
        createSourceFile(
            fs.getPath("/src/modules/foo/baz.js"),
            "exports.greeting1 = require('./bar').greet;",
            "",
            "const greet = require('./bar').greet;",
            "exports.greeting2 = greet;"));

    NominalType2 type = typeRegistry.getType("dossier$$module__$src$modules$foo$baz");
    TypeInspector.Report report = typeInspector.inspectType(type);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).containsExactly(
        Function.newBuilder()
            .setBase(BaseProperty.newBuilder()
                .setName("greeting1")
                .setSource(sourceFile("../source/modules/foo/baz.js.src.html", 1))
                .setDescription(htmlComment("<p>Hello, world!</p>\n")))
            .build(),
        Function.newBuilder()
            .setBase(BaseProperty.newBuilder()
                .setName("greeting2")
                .setSource(sourceFile("../source/modules/foo/baz.js.src.html", 4))
                .setDescription(htmlComment("<p>Hello, world!</p>\n")))
            .build());
  }
  
  @Test
  public void linkReferencesAreParsedRelativeToOwningType() {
    util.compile(
        createSourceFile(
            fs.getPath("/src/globals.js"),
            "/** Global person. */",
            "class Person {}"),
        createSourceFile(
            fs.getPath("/src/modules/foo/bar.js"),
            "",
            "/** Hides global person. */",
            "class Person {}",
            "exports.Person = Person;",
            "",
            "/** Greet a {@link Person}. */",
            "exports.greet = function() {};"));

    NominalType2 type = typeRegistry.getType("dossier$$module__$src$modules$foo$bar");
    TypeInspector.Report report = typeInspector.inspectType(type);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).containsExactly(
        Function.newBuilder()
            .setBase(BaseProperty.newBuilder()
                .setName("greet")
                .setSource(sourceFile("../source/modules/foo/bar.js.src.html", 7))
                .setDescription(htmlComment(
                    "<p>Greet a <a href=\"foo_bar_exports_Person.html\">"
                        + "<code>Person</code></a>.</p>\n")))
            .build());
  }
  
  @Test
  public void inspectGoogDefinedClass() {
    util.compile(fs.getPath("/src/foo.js"),
        "goog.provide('foo.bar');",
        "foo.bar.Baz = goog.defineClass(null, {",
        "  constructor: function() {},",
        "  statics: {",
        "    /** Does stuff. */",
        "    go: function() {}",
        "  }",
        "});");

    NominalType2 type = typeRegistry.getType("foo.bar.Baz");
    TypeInspector.Report report = typeInspector.inspectType(type);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).containsExactly(
        Function.newBuilder()
            .setBase(BaseProperty.newBuilder()
                .setName("Baz.go")
                .setSource(sourceFile("source/foo.js.src.html", 6))
                .setDescription(htmlComment("<p>Does stuff.</p>\n")))
            .build());
  }
  
  @Test
  public void inspectGoogDefinedInterface() {
    util.compile(fs.getPath("/src/foo.js"),
        "goog.provide('foo.bar');",
        "/** @interface */",
        "foo.bar.Baz = goog.defineClass(null, {",
        "  statics: {",
        "    /** Does stuff. */",
        "    go: function() {}",
        "  }",
        "});");

    NominalType2 type = typeRegistry.getType("foo.bar.Baz");
    TypeInspector.Report report = typeInspector.inspectType(type);
    assertThat(report.getProperties()).isEmpty();
    assertThat(report.getCompilerConstants()).isEmpty();
    assertThat(report.getFunctions()).containsExactly(
        Function.newBuilder()
            .setBase(BaseProperty.newBuilder()
                .setName("Baz.go")
                .setSource(sourceFile("source/foo.js.src.html", 6))
                .setDescription(htmlComment("<p>Does stuff.</p>\n")))
            .build());
  }
}
