package com.example.introspect

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltAndroidApp
class TopApp : Application(){
    private val applicationScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            //Timber.plant(CrashReportingTree())
        }
        /**
         *
         */
       // delayedInitForWorkManager()
    }

  /*  @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun getWorkManagerConfiguration() =
        androidx.work.Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .setMinimumLoggingLevel(android.util.Log.INFO)
            .build()

    private fun delayedInitForWorkManager() {
        applicationScope.launch {
            //setupRecurringWork()
            delayedInitForWorkManagerPushToServer()
        }
    }


    private fun delayedInitForWorkManagerPushToServer() {
        // Create Network constraint
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        Timber.e(
            "===== SyncDataWorker ========1==============\n SECOND=========${
                Calendar.getInstance().get(Calendar.SECOND)
            }===============\n MILLISECOND=============${
                Calendar.getInstance().get(Calendar.MILLISECOND)
            }===============\n MINUTE=======${
                Calendar.getInstance().get(Calendar.MINUTE)
            }===============\n DATE========${
                Calendar.getInstance().get(Calendar.DATE)
            }==============="
        )
        val periodicSyncDataWork =
            PeriodicWorkRequest.Builder(
                PushDatatoServerWorkManger::class.java,
                15,
                TimeUnit.MINUTES
            )
                .addTag(TAG_SYNC_DATA)
                .setConstraints(constraints) // setting a backoff on case the work needs to retry
                .setBackoffCriteria(
                    BackoffPolicy.LINEAR,
                    PeriodicWorkRequest.MIN_BACKOFF_MILLIS,
                    TimeUnit.MILLISECONDS
                )
                .build()
        WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
            SYNC_DATA_WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,  //Existing Periodic Work policy
            periodicSyncDataWork //work request
        )
    }*/


}