package id.asad.news.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.asad.news.R
import id.asad.news.databinding.FragmentSourcesBinding
import id.asad.news.ui.source.NewsBySourceActivity

class SourcesFragment : Fragment() {

    private lateinit var binding : FragmentSourcesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSourcesBinding.inflate(inflater, container, false)

        binding.cvBbc.setOnClickListener {
            val intent = Intent(context, NewsBySourceActivity::class.java)
            intent.putExtra(NewsBySourceActivity.KEY_SOURCE, getString(R.string.bbc_source))
            intent.putExtra(NewsBySourceActivity.KEY_SOURCE_CAPS, getString(R.string.bbc_news_title))
            context?.startActivity(intent)
        }
        binding.cvCnn.setOnClickListener {
            val intent = Intent(context, NewsBySourceActivity::class.java)
            intent.putExtra(NewsBySourceActivity.KEY_SOURCE, getString(R.string.cnn_source))
            intent.putExtra(NewsBySourceActivity.KEY_SOURCE_CAPS, getString(R.string.cnn_news_title))
            context?.startActivity(intent)
        }
        binding.cvWired.setOnClickListener {
            val intent = Intent(context, NewsBySourceActivity::class.java)
            intent.putExtra(NewsBySourceActivity.KEY_SOURCE, getString(R.string.wired_source))
            intent.putExtra(NewsBySourceActivity.KEY_SOURCE_CAPS, getString(R.string.wired_title))
            context?.startActivity(intent)
        }
        binding.cvFox.setOnClickListener {
            val intent = Intent(context, NewsBySourceActivity::class.java)
            intent.putExtra(NewsBySourceActivity.KEY_SOURCE, getString(R.string.fox_source))
            intent.putExtra(NewsBySourceActivity.KEY_SOURCE_CAPS, getString(R.string.fox_title))
            context?.startActivity(intent)
        }
        binding.cvReuters.setOnClickListener {
            val intent = Intent(context, NewsBySourceActivity::class.java)
            intent.putExtra(NewsBySourceActivity.KEY_SOURCE, getString(R.string.reuters_source))
            intent.putExtra(NewsBySourceActivity.KEY_SOURCE_CAPS, getString(R.string.reuters_title))
            context?.startActivity(intent)
        }
        binding.cvVice.setOnClickListener {
            val intent = Intent(context, NewsBySourceActivity::class.java)
            intent.putExtra(NewsBySourceActivity.KEY_SOURCE, getString(R.string.vice_source))
            intent.putExtra(NewsBySourceActivity.KEY_SOURCE_CAPS, getString(R.string.vice_news_title))
            context?.startActivity(intent)
        }
        binding.cvCbs.setOnClickListener {
            val intent = Intent(context, NewsBySourceActivity::class.java)
            intent.putExtra(NewsBySourceActivity.KEY_SOURCE, getString(R.string.cbs_source))
            intent.putExtra(NewsBySourceActivity.KEY_SOURCE_CAPS, getString(R.string.cbs_title))
            context?.startActivity(intent)
        }
        binding.cvEspn.setOnClickListener {
            val intent = Intent(context, NewsBySourceActivity::class.java)
            intent.putExtra(NewsBySourceActivity.KEY_SOURCE, getString(R.string.espn_source))
            intent.putExtra(NewsBySourceActivity.KEY_SOURCE_CAPS, getString(R.string.espn_title))
            context?.startActivity(intent)
        }
        binding.cvIndependent.setOnClickListener {
            val intent = Intent(context, NewsBySourceActivity::class.java)
            intent.putExtra(NewsBySourceActivity.KEY_SOURCE, getString(R.string.independent_source))
            intent.putExtra(NewsBySourceActivity.KEY_SOURCE_CAPS, getString(R.string.independent_title))
            context?.startActivity(intent)
        }

        return binding.root
    }


}