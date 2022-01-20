package io.art.linux.local.container.meta

import io.art.linux.local.container.model.Configuration
import io.art.meta.model.InstanceMetaMethod
import io.art.meta.model.MetaClass
import io.art.meta.model.MetaConstructor
import io.art.meta.model.MetaField
import io.art.meta.model.MetaLibrary
import io.art.meta.model.MetaPackage
import io.art.meta.model.MetaParameter
import io.art.meta.model.MetaType.metaArray
import io.art.meta.model.MetaType.metaEnum
import io.art.meta.model.MetaType.metaType
import kotlin.Any
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.Throwable
import kotlin.jvm.Throws

@Suppress("warnings")
public class MetaContainer : MetaLibrary {
  private val ioPackage: MetaIoPackage = register(MetaIoPackage())

  public constructor(vararg dependencies: MetaLibrary) : super(dependencies)

  public fun ioPackage(): MetaIoPackage = ioPackage

  public class MetaIoPackage : MetaPackage {
    private val artPackage: MetaArtPackage = register(MetaArtPackage())

    internal constructor() : super("io")

    public fun artPackage(): MetaArtPackage = artPackage

    public class MetaArtPackage : MetaPackage {
      private val linuxPackage: MetaLinuxPackage = register(MetaLinuxPackage())

      internal constructor() : super("art")

      public fun linuxPackage(): MetaLinuxPackage = linuxPackage

      public class MetaLinuxPackage : MetaPackage {
        private val localPackage: MetaLocalPackage = register(MetaLocalPackage())

        internal constructor() : super("linux")

        public fun localPackage(): MetaLocalPackage = localPackage

        public class MetaLocalPackage : MetaPackage {
          private val containerPackage: MetaContainerPackage = register(MetaContainerPackage())

          internal constructor() : super("local")

          public fun containerPackage(): MetaContainerPackage = containerPackage

          public class MetaContainerPackage : MetaPackage {
            private val modelPackage: MetaModelPackage = register(MetaModelPackage())

            internal constructor() : super("container")

            public fun modelPackage(): MetaModelPackage = modelPackage

            public class MetaModelPackage : MetaPackage {
              private val configurationClass: MetaConfigurationClass =
                  register(MetaConfigurationClass())

              internal constructor() : super("model")

              public fun configurationClass(): MetaConfigurationClass = configurationClass

              public class MetaConfigurationClass : MetaClass<Configuration> {
                private val `constructor`: MetaConstructorConstructor =
                    register(MetaConstructorConstructor())

                private val artVersionField: MetaField<String> =
                    register(MetaField("artVersion",metaType<String>(String::class.java),false))

                private final val getArtVersionMethod: MetaGetArtVersionMethod =
                    register(MetaGetArtVersionMethod())

                private val lxcVersionField: MetaField<String> =
                    register(MetaField("lxcVersion",metaType<String>(String::class.java),false))

                private final val getLxcVersionMethod: MetaGetLxcVersionMethod =
                    register(MetaGetLxcVersionMethod())

                internal constructor() : super(metaType<Configuration>(Configuration::class.java))

                public fun `constructor`(): MetaConstructorConstructor = constructor

                public fun artVersionField(): MetaField<String> = artVersionField

                public fun getArtVersionMethod(): MetaGetArtVersionMethod = getArtVersionMethod

                public fun lxcVersionField(): MetaField<String> = lxcVersionField

                public fun getLxcVersionMethod(): MetaGetLxcVersionMethod = getLxcVersionMethod

                public class MetaConstructorConstructor : MetaConstructor<Configuration> {
                  private val artVersionParameter: MetaParameter<String> = register(MetaParameter(0,
                      "artVersion",metaType<String>(String::class.java)))

                  private val lxcVersionParameter: MetaParameter<String> = register(MetaParameter(1,
                      "lxcVersion",metaType<String>(String::class.java)))

                  internal constructor() : super(metaType<Configuration>(Configuration::class.java))

                  @Throws(Throwable::class)
                  public override fun invoke(arguments: Array<Any>): Configuration {
                    return Configuration(arguments[0] as String,arguments[1] as String)
                  }

                  public fun artVersionParameter(): MetaParameter<String> = artVersionParameter

                  public fun lxcVersionParameter(): MetaParameter<String> = lxcVersionParameter
                }

                public class MetaGetArtVersionMethod : InstanceMetaMethod<Configuration, String> {
                  internal constructor() :
                      super("getArtVersion",metaType<String>(String::class.java))

                  @Throws(Throwable::class)
                  public override fun invoke(instance: Configuration): Any? = instance.artVersion

                  @Throws(Throwable::class)
                  public override fun invoke(instance: Configuration, arguments: Array<Any>): Any? =
                      instance.artVersion
                }

                public class MetaGetLxcVersionMethod : InstanceMetaMethod<Configuration, String> {
                  internal constructor() :
                      super("getLxcVersion",metaType<String>(String::class.java))

                  @Throws(Throwable::class)
                  public override fun invoke(instance: Configuration): Any? = instance.lxcVersion

                  @Throws(Throwable::class)
                  public override fun invoke(instance: Configuration, arguments: Array<Any>): Any? =
                      instance.lxcVersion
                }
              }
            }
          }
        }
      }
    }
  }
}
