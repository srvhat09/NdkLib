# NdkLib

## ABSTRACT(概要)
本レポジトリは、Android Studioを使ってNDKを利用したライブラリを作成する方のサンプルです。
2011年、ECRIPSE CDTとNDKライブラリを使ったライブラリが当レポジトリにありますが、Android Studioで同様の方法を試行錯誤した結果を纏め、私の備忘録兼何方かの役に立つことを念頭に公開します。

## 1. Repository Structure（レポジトリ構造）
- javawrapper : java library(aar + .so)
    - jni
        - Android.mk : for ndk build file
        - Application.mk : for ndk build file
        - nativelib.cpp : c++ source code
    - src
        - main
            - java
                - Java Source
            - AndroidManifest.xml
- myapplication : Test application for javawrapper library

この構造になっているのは、ライブラリを既存アプリケーション下にいきなり作成して開発するのでは無く、別プロジェクトあるいは、ライセンスの関係で公開する必要があるので分離する、ライセンスを変えたい等の関係がある場合はしばしばあることでしょう。
特に、GNU General Public Licenseだと、組み込んだらそのまま公開しないと不味いケースもあることでしょう。

ここでは、分離してJavaインタフェースを持つ（NDKライブラリの呼び出しコードすら外出ししたいケース）を想定したjavawrapperとjni。そのテスト用途でmyapplicationを用意しています。

## 2. Build Operation(ビルド手順)
### 2-1. Preparation(準備)
・SDK Manager→Android SDK→SDK Tools→NDK ダウンロードされていること
・Android SDKおよびAndroid NDKのパスがターミナル上で通っていること

### 2-2. Build(ビルド)
・Android Studio→Terminal→javawrapperディレクトリへ移動(cd javawrapperと打つ)→ndk-build -Bを打つ
　→問題が無ければjniがlibsディレクトリ下のCPU毎にlibhello_jni.soが生成
・javawrapperをProjectで選択し、Android Studioメニューバー→Build→Rebuild Project
　→問題が無ければjavawrapperプロジェクト→build→outputs→aar→javawrapper-debug.aarが生成
・myapplicationをProjectで選択し、src→main→jniLibs（ディレクトリ名は大文字小文字完全一致）にjavawrapperのlibs配下をコピーし、myapplicationを実行するとアプリケーションとして起動。
　aarの設定はmyapplication→build.gradleのimplementation projectでjavawrapperを設定している。利用するアプリケーションには、Android Studioメニューバー→File→New→New Module→Android Libraryを選択しソースを暫定的に作成。その後、中身を削除し、カスタムbuild.gradleとビルド済aarファイルを配置。取り込むプロジェクトのapp用build.gradleにimplementation projectを書き加え、Project StructureのDependenciesを確認すればOK。
