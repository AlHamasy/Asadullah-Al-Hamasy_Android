package id.asad.news.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.asad.news.R
import id.asad.news.ui.category.NewsByCategoryActivity
import id.asad.news.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {

    private lateinit var binding: FragmentCategoriesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCategoriesBinding.inflate(inflater,container, false)

        binding.cvBusiness.setOnClickListener {
            val intent = Intent(context, NewsByCategoryActivity::class.java)
            intent.putExtra(NewsByCategoryActivity.KEY_CATEGORY, getString(R.string.business_title))
            context?.startActivity(intent)
        }

        binding.cvEntertainment.setOnClickListener {
            val intent = Intent(context, NewsByCategoryActivity::class.java)
            intent.putExtra(NewsByCategoryActivity.KEY_CATEGORY, getString(R.string.entertainment_title))
            context?.startActivity(intent)
        }

        binding.cvGeneral.setOnClickListener {
            val intent = Intent(context, NewsByCategoryActivity::class.java)
            intent.putExtra(NewsByCategoryActivity.KEY_CATEGORY, getString(R.string.general_title))
            context?.startActivity(intent)
        }

        binding.cvHealth.setOnClickListener {
            val intent = Intent(context, NewsByCategoryActivity::class.java)
            intent.putExtra(NewsByCategoryActivity.KEY_CATEGORY, getString(R.string.health_title))
            context?.startActivity(intent)
        }

        binding.cvScience.setOnClickListener {
            val intent = Intent(context, NewsByCategoryActivity::class.java)
            intent.putExtra(NewsByCategoryActivity.KEY_CATEGORY, getString(R.string.science_title))
            context?.startActivity(intent)
        }

        binding.cvSports.setOnClickListener {
            val intent = Intent(context, NewsByCategoryActivity::class.java)
            intent.putExtra(NewsByCategoryActivity.KEY_CATEGORY, getString(R.string.sports_title))
            context?.startActivity(intent)
        }

        binding.cvTechnology.setOnClickListener {
            val intent = Intent(context, NewsByCategoryActivity::class.java)
            intent.putExtra(NewsByCategoryActivity.KEY_CATEGORY, getString(R.string.technology_title))
            context?.startActivity(intent)
        }

        return binding.root
    }

}