package io.art.linux.local.container.graal;

import com.oracle.svm.core.annotate.*;
import com.oracle.svm.hosted.*;
import com.oracle.svm.hosted.c.*;
import org.graalvm.nativeimage.hosted.*;

@AutomaticFeature
public class GraalLxcFeature implements Feature {
    @Override
    public void beforeAnalysis(BeforeAnalysisAccess access) {
        NativeLibraries nativeLibraries = ((FeatureImpl.BeforeAnalysisAccessImpl) access).getNativeLibraries();
        nativeLibraries.addStaticNonJniLibrary("lxc");
    }
}
