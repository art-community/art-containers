package io.art.linux.local.container.graal;

import com.oracle.svm.core.annotate.*;
import org.graalvm.nativeimage.hosted.*;
import static io.art.core.graal.GraalNativeRegistrator.*;
import static io.art.linux.local.container.graal.GraalLxcConstants.*;

@AutomaticFeature
public class GraalLxcFeature implements Feature {
    @Override
    public void beforeAnalysis(BeforeAnalysisAccess access) {
        registerStaticNonJniLibrary(access, LXC_NAME);
    }
}
