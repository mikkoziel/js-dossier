# Dossier

Dossier is a [JSDoc](http://en.wikipedia.org/wiki/JSDoc) parsing tool built on
top of the [Closure Compiler](https://developers.google.com/closure/compiler/).
Dossier uses the compiler to parse your code and build a type graph. It then
traverses the graph to find types to generate documentation for. Proper use of
Closure's [annotations](https://developers.google.com/closure/compiler/docs/js-for-compiler)
will not only improve the type-checking and optimizations of the Closure
Compiler, but will also improve Dossier's ability to generate meaningful documentation.

## Usage

_Dossier requires [Java 7](http://openjdk.java.net/) or newer_

```sh
java -jar dossier.jar -c config.json
```

Where `config.json` is a configuration file with the options listed below.

__Configuration Options__

 * `closureDepFiles` Path to a file to parse for calls to `goog.addDependency`.
    This option requires also setting `closureLibraryDir`.

 * `closureLibraryDir` Path to the base directory of the Closure library (which
    must contain base.js and deps.js). When this option is specified, Closure's
    deps.js and all of the files specified by `closureDepsFile` will be parsed
    for calls to `goog.addDependency`. The resulting map will be used to
    automatically expand the set of `sources` any time a symbol is
    goog.require'd with the ile that goog.provides that symbol, along with all
    of its transitive dependencies.

    For example, suppose you have one source file, `foo.js`:

   ```js
   goog.require('goog.array');
   // ...
   ```

    and your configuration includes:

   ```json
   "sources": ["foo.js"],
   "closureLibraryDir": "closure/goog"
   ```

    due to the dependencies of goog.array declared in closure/goog/deps.js,
    this is equivalent to the following configuration:

   ```json
   "sources": [
       "closure/goog/base.js",
       "closure/goog/debug/error.js",
       "closure/goog/string/string.js",
       "closure/goog/asserts/asserts.js",
       "closure/goog/array/array.js",
       "foo.js"
   ]
   ```

    Notice specifying `closureLibraryDir` instructs Dossier to sort the input
    files so a a file that goog.provides symbol X comes before any file that
    goog.requires X.

 * `customPages` List of additional files to include in the generated
    documentation. Each page is defined as a {name: string, path: string}
    object, where the name is what's displayed in the navigation menu, and
    `path` is the path to the markdown file to use. Files will be included in
    the order listed, after the standard navigation items.

 * `excludes` A list of .js files to exclude from processing. If a directory is
    specified, all of the .js files under that directory will be excluded. A
    glob pattern may also be specified to exclude all of the paths under the
    current working directory that match  the provided pattern.

 * `externModules` A list of .js files to include as CommonJS extern module
    definitions. Each module may be required in source by the file's base name,
    excluding the extension. For example, 'extern/libfoo.js' would provide the
    extern definition for the import `require('libfoo');`

 * `externs` A list of .js files to include as an extern file for the Closure
    compiler. These  files are used to satisfy references to external types,
    but are excluded when generating  API documentation.

 * `moduleFilters` List of regular expressions for modules that should be
    excluded from generated documentation, even if found in the type graph. The
    provided expressions will be to the _absolute_ path of the source file for
    each module.

 * `moduleNamingConvention` The module naming convention to use. If set to
    `NODE`, modules with a basename of index.js will use the name of the parent
    directory (e.g. "foo/bar/index.js" -> "foo/bar/"). Must be one of {ES6,
    NODE}; defaults to ES6

 * `modulePrefix` A prefix to strip from every module's path when generating
    documentation. The specified path must be a directory that is an ancestor
    of every file specified in `modules`. Note: if this option is omitted, the
    closest common ancestor for all module files will be selected as the
    default.

 * `modules` A list of .js files to extract API documentation from. Each file
    will be processed as a CommonJS module, with only its exported API included
    in the generated output. If a glob pattern is specified, every .js file
    under the current directory matching that pattern will be included.
    Specifying the path to a directory, `foo`, is the same as the glob pattern
    `foo/**.js`. The set of paths specified by this option *mut* be disjoint
    from those specified by `sources`.

 * `output` Path to the directory to write all generated documentation to. This
    field is required.

 * `readme` Path to a README file to include as the main landing page for the
    generated documentation. This file should use markdown syntax.

 * `sourcePrefix` A prefix to strip from every input file's path (source &
    module) when rendering source paths. Notably, paths will be inserted into
    the source URL template after this prefix has been removed. If this option
    is omitted, the closest common ancestor for all input files will be used as
    the default.

 * `sourceUrlTemplate` Specifies a template from which to generate a HTTP(S)
    links to source files. Within this template, the `%path%` and `%line%`
    tokens will be replaced with the linked type's source file path and line
    number, respectively. Source paths will be relative to the closest common
    ancestor of all input files.

    If this option is not specified, a rendered copy of each input file will be
    included in the generated output.

 * `sources` A list of .js files to extract API documentation from. If a glob
    pattern is specified, every .js file under the current working directory
    matching that pattern will be included. Specifying the path to a directory,
    `foo`, is the same as using the glob pattern `foo/**.js`. The set of paths
    specified by this option *must* be disjoint from those specified by
    `modules`.

 * `strict` Whether to run with all type checking flags enabled.

 * `typeFilters` List of regular expressions for types that should be excluded
    from generated documentation, even if found in the type graph.


## ES6 Support

Dossier supports ES6 code insofar as the [Closure Compiler](https://github.com/google/closure-compiler/wiki/ECMAScript6)
does. Since the compiler transpiles ES6 to ES5 for analysis, there is some
information loss with Dossier. Most notably, type information is lost for
`Symbol` types and generator functions. To use Dossier with ES6 code, in your
configuration file, simply set the input `language` to `ES6` or
`ES6_STRICT` (which is the default).

### Module Support

Dossier currently recognizes three types of JavaScript modules:

1. Closure modules identified by `goog.module(id)` declaration
2. ES6 modules identified by the use of an `export` or `import` declaration
3. Node-style CommonJS modules

Node modules must be explicitly declared as `modules` inputs in your
configuration file so Dossier knows to look for `require()` and
`exports` expressions.

For Node and ES6 modules, you may import other modules by their _relative_
path:

```js
import {Foo as Bar} from './lib';  // ES6
const Baz = require('./dir/lib');  // Node
```

Refer to the section on [type linking](#type-linking) below for information
on how to refer to imported types within a JSDoc comment.

## Formatting

Before generating the final HTML output, Dossier runs all comments through a
[CommonMark](http://commonmark.org/) parser. Since markdown is sensitive to the
leading whitespace on each line, care must be taken with comment formatting.
Comments are extracted from the source according to the follow rules:

1. The `/**` on the opening line is removed; all subsequent content is
   considered part of the comment.
2. On each subsequent line, all whitespace up to the first non-space character
   is removed.
3. If the first character on a line after removing whitespace is a `*`, it
   is removed from the line. All subsequent content is considered part of the
   comment.
4. On the final line, the closing `*/` is removed.

For example, the JSDoc comment (.'s inserted to highlight whitespace)

```js
/**
.*.Line one.
.*.Line two.
.*
.*.* list item one
.*.* line item two
.*
.*.....code block
.*/
```

is passed to the parser as

```
.Line one.
.Line two.

.* list item one
.* list item two

.....code block
```

When applied to comments attached to annotations, the same rules apply, except
the comment text starts after the annotation, type, or name (as applicable for
the annotation). For instance,

```js
/**
 * @param {string} x This is the comment for
 *     parameter x.
 */
```

the comment string parsed for parameter `x` is (again, .'s inserted to denote
leading whitespace):

```
.This is the comment for
.....parameter x.
```

### The `@code` and `@literal` Taglets

The `@code` and `@literal` taglets may be used to specify text that
should be HTML escaped for rendering; the `@code` taglet will wrap its
output in `<code>` tags. For example, the following

```js
{@code 1 < 2 && 3 < 4;}
```

will produce

```html
<code>1 &lt; 2 &amp;&amp; 3 &lt; 4;</code>
```

### Type Linking <a name="type-linking"></a>

Dossier uses the `@link` and `@linkplain` taglets to generate links to
named types (`@link` will generate `<code>` formatted links).  The taglet
contents up to the first space are parsed as the type name and everything after
the space is the link text. If there is no text within the taglet, the type
name will be used. For example, suppose there is a type named
`example.Widget`, then

```
An {@link example.Widget} link.
A {@link example.Widget widget link}.
```

would produce

```html
An <a href="path/to/example.Widget.html"><code>example.Widget</code></a> link.
A <a href="path/to/example.Widget.html"><code>widget link</code></a>.
```

You may use a hash tag (#) to reference a type's property inside a link:
`{@link example.Widget#build()}`. You may omit the type's name
as a qualifier when linking to one of its own properties:
`{@link #build()}`. Dossier will favor instance over static
properties when de-referencing a hash link.

Dossier tracks type aliases so your documentation may reflect the actual source.
For instance, if you import a type from a module, you may refer to that type
by its imported alias:

```js
import {Widget as Whatsit} from './lib';

/** A {@link Whatsit} object. */
export const w = new Whatsit;
```

Here, the comment on the exported `w` property produces

```html
<p>A <a href="module/lib_exports_Widget"><code>Whatsit</code></a> object.</p>
```

When using the [revealing module pattern](https://carldanley.com/js-revealing-module-pattern/),
your module's documentation can refer to a type by its internal name and
Dossier will generate a link to the exported type.

```js
class Widget {}

/** A factory that generates {@link Widget} objects. */
class WidgetFactory {}

export {Widget as WhatsIt, WidgetFactory}
```

In the above, since `Widget`'s public name is `WhatsIt`, the generate
documentation would be (extra newlines inserted for readability)

```html
<p>A factory that generates
<a href="module/lib_exports_WhatsIt.html"><code>Widget</code></a> objects.
</p>
```

Within an ES6 or Node module, you may refer to another module without importing
using the module's _relative_ path as your type symbol. To refer to an exported
type from another module, simply qualify it with the module's relative path.

```js
/** A link to module {@link ./foo/bar} */
/** A link to type {@link ./foo/bar.Baz} */
```

### The `@see` Annotation

Use the `@see` annotation in your JSDoc to add a reference to another
type or an external resource. The text context following the annotation is
processed in the following order:

1. The annotation contents are processed as a type link using the rules defined
   in the previous section. If the contents define a valid reference to another
   type or property, a link will be included in the HTML output.
2. If the annotation is a well-formed http or https URL, it will be rendered as
   a link.
3. Otherwise, the contents of the annotation are processed as markdown like a
   comment's main body.


__Example__

```js
class Greeter {
  /** @param {!Person} person . */
  greet(person) {}
}

/**
 * @see Greeter
 * @see #name
 * @see http://www.example.com
 */
class Person {
  /** @return {string} . */
  name() { return ''; }
}
```

In this example, the `@see` annotations on the `Person` class would
generate the following links:

```html
<a href="Greeter.html"><code>Greeter</code></a>
<a href="Person.html#name"><code>#name</code></a>
<a href="http://www.example.com">http://www.example.com</a>
```

## HTML Sanitization

All HTML output is sanitized using the [owasp HTML sanitizer](https://github.com/owasp/java-html-sanitizer).
Refer to the [source](https://github.com/jleyba/js-dossier/blob/master/src/java/com/github/jsdossier/soy/HtmlSanitizer.java)
for an up-to-date list of the supported HTML tags and attributes.

## Building

Dossier is built using [Bazel](http://bazel.io/). Once
you have [installed](http://bazel.io/docs/install.html) Bazel,
you can use the `gendossier.sh` script to complete various actions:

```
./gendossier.sh -h
```

## LICENSE

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
