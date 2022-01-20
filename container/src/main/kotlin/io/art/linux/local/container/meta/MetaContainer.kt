package io.art.linux.local.container.meta

import io.art.http.communicator.HttpCommunicationDecorator
import io.art.linux.local.container.DownloadConnector
import io.art.linux.local.container.model.Configuration
import io.art.meta.model.InstanceMetaMethod
import io.art.meta.model.MetaClass
import io.art.meta.model.MetaConstructor
import io.art.meta.model.MetaField
import io.art.meta.model.MetaLibrary
import io.art.meta.model.MetaMethod
import io.art.meta.model.MetaPackage
import io.art.meta.model.MetaParameter
import io.art.meta.model.MetaProxy
import io.art.meta.model.MetaType.metaArray
import io.art.meta.model.MetaType.metaEnum
import io.art.meta.model.MetaType.metaType
import java.util.function.Function
import java.util.function.UnaryOperator
import kotlin.Any
import kotlin.Array
import kotlin.Byte
import kotlin.ByteArray
import kotlin.String
import kotlin.Suppress
import kotlin.Throwable
import kotlin.collections.Map
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
            private val downloadConnectorClass: MetaDownloadConnectorClass =
                register(MetaDownloadConnectorClass())

            private val modelPackage: MetaModelPackage = register(MetaModelPackage())

            internal constructor() : super("container")

            public fun downloadConnectorClass(): MetaDownloadConnectorClass = downloadConnectorClass

            public fun modelPackage(): MetaModelPackage = modelPackage

            public class MetaDownloadConnectorClass : MetaClass<DownloadConnector> {
              private final val downloaderMethod: MetaDownloaderMethod =
                  register(MetaDownloaderMethod())

              private val downloaderClass: MetaDownloaderClass = register(MetaDownloaderClass())

              internal constructor() :
                  super(metaType<DownloadConnector>(DownloadConnector::class.java))

              public fun downloaderMethod(): MetaDownloaderMethod = downloaderMethod

              public override fun proxy(invocations: Map<MetaMethod<*>, Function<Any?, Any?>>):
                  MetaProxy = MetaDownloadConnectorProxy(invocations)

              public fun downloaderClass(): MetaDownloaderClass = downloaderClass

              public class MetaDownloaderMethod :
                  InstanceMetaMethod<DownloadConnector, DownloadConnector.Downloader> {
                internal constructor() :
                    super("downloader",metaType<DownloadConnector.Downloader>(DownloadConnector.Downloader::class.java))

                @Throws(Throwable::class)
                public override fun invoke(instance: DownloadConnector, arguments: Array<Any>):
                    Any? {
                  return instance.downloader()
                }

                @Throws(Throwable::class)
                public override fun invoke(instance: DownloadConnector): Any? {
                  return instance.downloader()
                }
              }

              public inner class MetaDownloadConnectorProxy : MetaProxy, DownloadConnector {
                private final val downloaderInvocation: Function<Any?, Any?>

                public constructor(invocations: Map<MetaMethod<*>, Function<Any?, Any?>>) :
                    super(invocations) {
                  downloaderInvocation = invocations[downloaderMethod]!!
                }

                public override fun downloader(): DownloadConnector.Downloader =
                    downloaderInvocation.apply(null) as DownloadConnector.Downloader
              }

              public class MetaDownloaderClass : MetaClass<DownloadConnector.Downloader> {
                private final val getFileMethod: MetaGetFileMethod = register(MetaGetFileMethod())

                private final val decorateMethod: MetaDecorateMethod =
                    register(MetaDecorateMethod())

                internal constructor() :
                    super(metaType<DownloadConnector.Downloader>(DownloadConnector.Downloader::class.java))

                public fun getFileMethod(): MetaGetFileMethod = getFileMethod

                public fun decorateMethod(): MetaDecorateMethod = decorateMethod

                public override fun proxy(invocations: Map<MetaMethod<*>, Function<Any?, Any?>>):
                    MetaProxy = MetaDownloaderProxy(invocations)

                public class MetaGetFileMethod :
                    InstanceMetaMethod<DownloadConnector.Downloader, ByteArray> {
                  internal constructor() :
                      super("getFile",metaArray<ByteArray>(ByteArray::class.java, { size: Int ->
                      arrayOfNulls<Byte>(size) }, metaType<Byte>(Byte::class.javaPrimitiveType)))

                  @Throws(Throwable::class)
                  public override fun invoke(instance: DownloadConnector.Downloader,
                      arguments: Array<Any>): Any? {
                    return instance.getFile()
                  }

                  @Throws(Throwable::class)
                  public override fun invoke(instance: DownloadConnector.Downloader): Any? {
                    return instance.getFile()
                  }
                }

                public class MetaDecorateMethod :
                    InstanceMetaMethod<DownloadConnector.Downloader, DownloadConnector.Downloader> {
                  private val p0Parameter: MetaParameter<UnaryOperator<HttpCommunicationDecorator>>
                      = register(MetaParameter(0,
                      "p0",metaType<UnaryOperator<HttpCommunicationDecorator>>(UnaryOperator::class.java,metaType<HttpCommunicationDecorator>(HttpCommunicationDecorator::class.java))))

                  internal constructor() :
                      super("decorate",metaType<DownloadConnector.Downloader>(DownloadConnector.Downloader::class.java))

                  @Throws(Throwable::class)
                  public override fun invoke(instance: DownloadConnector.Downloader,
                      arguments: Array<Any>): Any? {
                    return instance.decorate(arguments[0] as
                        UnaryOperator<HttpCommunicationDecorator>)
                  }

                  @Throws(Throwable::class)
                  public override fun invoke(instance: DownloadConnector.Downloader, argument: Any):
                      Any? {
                    return instance.decorate(argument as UnaryOperator<HttpCommunicationDecorator>)
                  }

                  public fun p0Parameter(): MetaParameter<UnaryOperator<HttpCommunicationDecorator>>
                      = p0Parameter
                }

                public inner class MetaDownloaderProxy : MetaProxy, DownloadConnector.Downloader {
                  private final val getFileInvocation: Function<Any?, Any?>

                  public constructor(invocations: Map<MetaMethod<*>, Function<Any?, Any?>>) :
                      super(invocations) {
                    getFileInvocation = invocations[getFileMethod]!!
                  }

                  public override fun getFile(): ByteArray = getFileInvocation.apply(null) as
                      ByteArray
                }
              }
            }

            public class MetaModelPackage : MetaPackage {
              private val configurationClass: MetaConfigurationClass =
                  register(MetaConfigurationClass())

              internal constructor() : super("model")

              public fun configurationClass(): MetaConfigurationClass = configurationClass

              public class MetaConfigurationClass : MetaClass<Configuration> {
                private val `constructor`: MetaConstructorConstructor =
                    register(MetaConstructorConstructor())

                private val artField: MetaField<String> =
                    register(MetaField("art",metaType<String>(String::class.java),false))

                private final val getArtMethod: MetaGetArtMethod = register(MetaGetArtMethod())

                private val lxcField: MetaField<String> =
                    register(MetaField("lxc",metaType<String>(String::class.java),false))

                private final val getLxcMethod: MetaGetLxcMethod = register(MetaGetLxcMethod())

                internal constructor() : super(metaType<Configuration>(Configuration::class.java))

                public fun `constructor`(): MetaConstructorConstructor = constructor

                public fun artField(): MetaField<String> = artField

                public fun getArtMethod(): MetaGetArtMethod = getArtMethod

                public fun lxcField(): MetaField<String> = lxcField

                public fun getLxcMethod(): MetaGetLxcMethod = getLxcMethod

                public class MetaConstructorConstructor : MetaConstructor<Configuration> {
                  private val artParameter: MetaParameter<String> = register(MetaParameter(0,
                      "art",metaType<String>(String::class.java)))

                  private val lxcParameter: MetaParameter<String> = register(MetaParameter(1,
                      "lxc",metaType<String>(String::class.java)))

                  internal constructor() : super(metaType<Configuration>(Configuration::class.java))

                  @Throws(Throwable::class)
                  public override fun invoke(arguments: Array<Any>): Configuration {
                    return Configuration(arguments[0] as String,arguments[1] as String)
                  }

                  public fun artParameter(): MetaParameter<String> = artParameter

                  public fun lxcParameter(): MetaParameter<String> = lxcParameter
                }

                public class MetaGetArtMethod : InstanceMetaMethod<Configuration, String> {
                  internal constructor() : super("getArt",metaType<String>(String::class.java))

                  @Throws(Throwable::class)
                  public override fun invoke(instance: Configuration): Any? = instance.art

                  @Throws(Throwable::class)
                  public override fun invoke(instance: Configuration, arguments: Array<Any>): Any? =
                      instance.art
                }

                public class MetaGetLxcMethod : InstanceMetaMethod<Configuration, String> {
                  internal constructor() : super("getLxc",metaType<String>(String::class.java))

                  @Throws(Throwable::class)
                  public override fun invoke(instance: Configuration): Any? = instance.lxc

                  @Throws(Throwable::class)
                  public override fun invoke(instance: Configuration, arguments: Array<Any>): Any? =
                      instance.lxc
                }
              }
            }
          }
        }
      }
    }
  }
}
