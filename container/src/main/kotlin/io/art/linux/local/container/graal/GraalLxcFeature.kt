package io.art.linux.local.container.graal

import com.oracle.svm.core.annotate.AutomaticFeature
import com.oracle.svm.hosted.FeatureImpl
import com.oracle.svm.hosted.c.NativeLibraries
import org.graalvm.nativeimage.hosted.Feature

@AutomaticFeature
class GraalLxcFeature : Feature {
    override fun beforeAnalysis(access: Feature.BeforeAnalysisAccess) {
        val nativeLibraries: NativeLibraries = (access as FeatureImpl.BeforeAnalysisAccessImpl).getNativeLibraries()
        nativeLibraries.addStaticNonJniLibrary("lxc")
    }
}
