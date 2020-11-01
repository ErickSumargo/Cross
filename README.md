[<img src="assets/logo.png" width="400" height="145">]()

[![Build Status](https://travis-ci.com/ErickSumargo/Cross.svg?branch=main)](https://travis-ci.com/ErickSumargo/Cross)
[![codecov](https://codecov.io/gh/ErickSumargo/Cross/branch/main/graph/badge.svg)](https://codecov.io/gh/ErickSumargo/Cross)

So I've written out my personal compilation code review set in:
<br/>
https://proandroiddev.com/personal-request-changes-materials-starter-pack-kotlin-ver-part-1-9a938f3768ad,
https://proandroiddev.com/personal-request-changes-materials-starter-pack-kotlin-ver-part-2-426084b9c9a1.

Those docs really save me instead of re-explaining every time similar issues pop in code review activity.
But still, re-introducing them to every new reviewee is kinda inevitably. 

So I wonder if only I can have, let's say a bot to represent this boring task. Well, actually there is. 
What I only need is to create custom lints and leverage `com.android.tools.lint` APIs to make it happen. Below are the PoCs.

## Proof of Concept (PoC)
A recap (not all should be implemented tho):

### 1. No Meaningless Nullable Primitives
[Implementation](https://github.com/ErickSumargo/Cross/blob/main/lint/src/main/java/com/bael/cross/lint/handler/NullablePrimitiveHandler.kt)<br/>
[UT](https://github.com/ErickSumargo/Cross/blob/main/lint/src/test/java/com/bael/cross/lint/handler/NullablePrimitiveHandlerTest.kt)<br/>
[Result](https://github.com/ErickSumargo/Cross/pull/17)

### 2. Kotlin’s Named Arguments
[Implementation](https://github.com/ErickSumargo/Cross/blob/main/lint/src/main/java/com/bael/cross/lint/handler/NamedArgumentHandler.kt)<br/>
[UT](https://github.com/ErickSumargo/Cross/blob/main/lint/src/test/java/com/bael/cross/lint/handler/NamedArgumentHandlerTest.kt)<br/>
[Result](https://github.com/ErickSumargo/Cross/pull/18)

### 4. Max. 1 Nested Condition Block Tolerance
[Implementation](https://github.com/ErickSumargo/Cross/blob/main/lint/src/main/java/com/bael/cross/lint/handler/NestedConditionHandler.kt)<br/>
[UT](https://github.com/ErickSumargo/Cross/blob/main/lint/src/test/java/com/bael/cross/lint/handler/NestedConditionHandlerTest.kt)<br/>
[Result](https://github.com/ErickSumargo/Cross/pull/19)

### 5. Destructuring Declarations? Not even once
[Implementation](https://github.com/ErickSumargo/Cross/blob/main/lint/src/main/java/com/bael/cross/lint/handler/DestructuringDeclarationHandler.kt)<br/>
[UT](https://github.com/ErickSumargo/Cross/blob/main/lint/src/test/java/com/bael/cross/lint/handler/DestructuringDeclarationHandlerTest.kt)<br/>
[Result](https://github.com/ErickSumargo/Cross/pull/20)

### 6. It's XUtils
[Implementation](https://github.com/ErickSumargo/Cross/blob/main/lint/src/main/java/com/bael/cross/lint/handler/UtilsNamingHandler.kt)<br/>
[UT](https://github.com/ErickSumargo/Cross/blob/main/lint/src/test/java/com/bael/cross/lint/handler/UtilsNamingHandlerTest.kt)<br/>
[Result](https://github.com/ErickSumargo/Cross/pull/21)

### 7. Public Methods as API Contracts
[Implementation](https://github.com/ErickSumargo/Cross/blob/main/lint/src/main/java/com/bael/cross/lint/handler/PublicMethodHandler.kt)<br/>
[UT](https://github.com/ErickSumargo/Cross/blob/main/lint/src/test/java/com/bael/cross/lint/handler/PublicMethodHandlerTest.kt)<br/>
[Result](https://github.com/ErickSumargo/Cross/pull/22)

### 9. Constructors Should Be Code-Free
[Implementation](https://github.com/ErickSumargo/Cross/blob/main/lint/src/main/java/com/bael/cross/lint/handler/InitBlockHandler.kt)<br/>
[UT](https://github.com/ErickSumargo/Cross/blob/main/lint/src/test/java/com/bael/cross/lint/handler/InitBlockHandlerTest.kt)<br/>
[Result](https://github.com/ErickSumargo/Cross/pull/23)

### 10. A Class is Either Final or Abstract
[Implementation](https://github.com/ErickSumargo/Cross/blob/main/lint/src/main/java/com/bael/cross/lint/handler/OpenModifierHandler.kt)<br/>
[UT](https://github.com/ErickSumargo/Cross/blob/main/lint/src/test/java/com/bael/cross/lint/handler/OpenModifierHandlerTest.kt)<br/>
[Result](https://github.com/ErickSumargo/Cross/pull/24)

### 11. The Temporal Coupling
[Implementation](https://github.com/ErickSumargo/Cross/blob/main/lint/src/main/java/com/bael/cross/lint/handler/TemporalCouplingHandler.kt)<br/>
[UT](https://github.com/ErickSumargo/Cross/blob/main/lint/src/test/java/com/bael/cross/lint/handler/TemporalCouplingHandlerTest.kt)<br/>
[Result](https://github.com/ErickSumargo/Cross/pull/25)

## ⚠️ Disclaimer ⚠️
This project **should only be used** for research purpose. 
Plug those lints into your codebase is discouraged unless you do really understand why and how they react to corresponding issue.

## License
    MIT License

    Copyright (c) 2020 ErickSumargo

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
