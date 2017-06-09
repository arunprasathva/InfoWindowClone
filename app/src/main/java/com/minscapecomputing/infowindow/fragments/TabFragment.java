package com.minscapecomputing.infowindow.fragments;

import com.minscapecomputing.infowindow.R;
import com.minscapecomputing.infowindow.VideoDialogFragment;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import uk.co.deanwild.flowtextview.FlowTextView;

public class TabFragment extends Fragment {

    private LinearLayout linearLayout;
    private int position;

    public enum TEMPLATE {
        IMAGE_TEXT,
        VIDEO_TEXT,
        ONLY_IMAGE,
        ONLY_VIDEO,
        ONLY_TEXT
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey("position")) {
                position = getArguments().getInt("position");
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view;

        if (position == 2 || position == 3) {
            view = inflater.inflate(R.layout.tab_fragment_without_scroll, container, false);
        } else {
            view = inflater.inflate(R.layout.tab_fragment, container, false);
        }

        init(view);
        setContent(container);

        return view;
    }

    private void init(View view) {

        linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
    }

    public void setContent(ViewGroup container) {

        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        switch (position) {
            case 0:
                createView(TEMPLATE.IMAGE_TEXT, inflater, container);
                break;
            case 1:
                createView(TEMPLATE.VIDEO_TEXT, inflater, container);
                break;
            case 2:
                createView(TEMPLATE.ONLY_IMAGE, inflater, container);
                break;
            case 3:
                createView(TEMPLATE.ONLY_VIDEO, inflater, container);
                break;
        }
    }

    private void createView(TEMPLATE type, LayoutInflater inflater, ViewGroup container) {

        switch (type) {

            case IMAGE_TEXT: {
                View view1 = inflater.inflate(R.layout.image_with_text, container, false);
                FlowTextView flowTextView1 = (FlowTextView) view1.findViewById(R.id.textView);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    flowTextView1.setText(Html.fromHtml("Our heritage and artisan communities need to be increasingly relevant for modern society. To this end, Caravan works towards a sophisticated language for Indic crafts. Every Caravan product has a handcrafted element from a traditional Indian craft cluster. To achieve precision and consistent quality, which is the hallmark of Caravan, artisan communities are up-skilled to achieve the level of desired sophistication.<br>Filigree, the exquisite technique of crafting precious metal wires into ornamental designs can be traced back 5000 years to Mesopotamia.  Owing to the common influence and origin, Greek and Indian filigree till date, display similar patterns and processes. <br>This age old, yet contemporary craft involves the silversmith crimping thin strips of fine silver into zig-zag patterns and loops using it to fill up the ground of designs formed by thicker silver strips. These strips and fine silver are then deftly soldered, carefully avoiding the trellis-like Filigree pattern. Traditional motifs of the flora and fauna are popular; however, the versatility of the art is not restricted by tradition. The art has been extensively extended from jewellery to making other ornate objects. Cuttack in Orissa and Karimnagar in Andhra Pradesh are the key centers of Filigree work in India.", Html.FROM_HTML_MODE_LEGACY));
                } else {
                    flowTextView1.setText(Html.fromHtml("Our heritage and artisan communities need to be increasingly relevant for modern society. To this end, Caravan works towards a sophisticated language for Indic crafts. Every Caravan product has a handcrafted element from a traditional Indian craft cluster. To achieve precision and consistent quality, which is the hallmark of Caravan, artisan communities are up-skilled to achieve the level of desired sophistication.<br>Filigree, the exquisite technique of crafting precious metal wires into ornamental designs can be traced back 5000 years to Mesopotamia.  Owing to the common influence and origin, Greek and Indian filigree till date, display similar patterns and processes. <br>This age old, yet contemporary craft involves the silversmith crimping thin strips of fine silver into zig-zag patterns and loops using it to fill up the ground of designs formed by thicker silver strips. These strips and fine silver are then deftly soldered, carefully avoiding the trellis-like Filigree pattern. Traditional motifs of the flora and fauna are popular; however, the versatility of the art is not restricted by tradition. The art has been extensively extended from jewellery to making other ornate objects. Cuttack in Orissa and Karimnagar in Andhra Pradesh are the key centers of Filigree work in India."));
                }
                try {
                    Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "RobotoRegular.ttf");
                    flowTextView1.setTypeface(typeface);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                flowTextView1.setTextSize(16f);
                view1.findViewById(R.id.expand).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("image", R.drawable.banner1);
                        ImageViewFragment imageViewFragment = ImageViewFragment.newInstance(bundle);
                        imageViewFragment.show(getChildFragmentManager(), "Image View Fragment");
                    }
                });
                linearLayout.addView(view1);

                View view = inflater.inflate(R.layout.image_with_text, container, false);
                FlowTextView flowTextView = (FlowTextView) view.findViewById(R.id.textView);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    flowTextView.setText(Html.fromHtml("Our heritage and artisan communities need to be increasingly relevant for modern society. To this end, Caravan works towards a sophisticated language for Indic crafts. Every Caravan product has a handcrafted element from a traditional Indian craft cluster. To achieve precision and consistent quality, which is the hallmark of Caravan, artisan communities are up-skilled to achieve the level of desired sophistication.<br>Filigree, the exquisite technique of crafting precious metal wires into ornamental designs can be traced back 5000 years to Mesopotamia.  Owing to the common influence and origin, Greek and Indian filigree till date, display similar patterns and processes. <br>This age old, yet contemporary craft involves the silversmith crimping thin strips of fine silver into zig-zag patterns and loops using it to fill up the ground of designs formed by thicker silver strips. These strips and fine silver are then deftly soldered, carefully avoiding the trellis-like Filigree pattern. Traditional motifs of the flora and fauna are popular; however, the versatility of the art is not restricted by tradition. The art has been extensively extended from jewellery to making other ornate objects. Cuttack in Orissa and Karimnagar in Andhra Pradesh are the key centers of Filigree work in India.", Html.FROM_HTML_MODE_LEGACY));
                } else {
                    flowTextView.setText(Html.fromHtml("Our heritage and artisan communities need to be increasingly relevant for modern society. To this end, Caravan works towards a sophisticated language for Indic crafts. Every Caravan product has a handcrafted element from a traditional Indian craft cluster. To achieve precision and consistent quality, which is the hallmark of Caravan, artisan communities are up-skilled to achieve the level of desired sophistication.<br>Filigree, the exquisite technique of crafting precious metal wires into ornamental designs can be traced back 5000 years to Mesopotamia.  Owing to the common influence and origin, Greek and Indian filigree till date, display similar patterns and processes. <br>This age old, yet contemporary craft involves the silversmith crimping thin strips of fine silver into zig-zag patterns and loops using it to fill up the ground of designs formed by thicker silver strips. These strips and fine silver are then deftly soldered, carefully avoiding the trellis-like Filigree pattern. Traditional motifs of the flora and fauna are popular; however, the versatility of the art is not restricted by tradition. The art has been extensively extended from jewellery to making other ornate objects. Cuttack in Orissa and Karimnagar in Andhra Pradesh are the key centers of Filigree work in India."));
                }
                try {
                    Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "RobotoRegular.ttf");
                    flowTextView.setTypeface(typeface);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                flowTextView.setTextSize(16f);
                ((ImageView)view.findViewById(R.id.imageView)).setImageResource(R.drawable.banner7);
                view.findViewById(R.id.expand).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("image", R.drawable.banner7);
                        ImageViewFragment imageViewFragment = ImageViewFragment.newInstance(bundle);
                        imageViewFragment.show(getChildFragmentManager(), "Image View Fragment");
                    }
                });
                view.findViewById(R.id.secondArticle).setVisibility(View.VISIBLE);
                linearLayout.addView(view);
                break;
            }
            case VIDEO_TEXT: {
                View view = inflater.inflate(R.layout.video_with_text, container, false);
                FlowTextView flowTextView = (FlowTextView) view.findViewById(R.id.textView);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    flowTextView.setText(Html.fromHtml("Our heritage and artisan communities need to be increasingly relevant for modern society. To this end, Caravan works towards a sophisticated language for Indic crafts. Every Caravan product has a handcrafted element from a traditional Indian craft cluster. To achieve precision and consistent quality, which is the hallmark of Caravan, artisan communities are up-skilled to achieve the level of desired sophistication.<br>Filigree, the exquisite technique of crafting precious metal wires into ornamental designs can be traced back 5000 years to Mesopotamia.  Owing to the common influence and origin, Greek and Indian filigree till date, display similar patterns and processes. <br>This age old, yet contemporary craft involves the silversmith crimping thin strips of fine silver into zig-zag patterns and loops using it to fill up the ground of designs formed by thicker silver strips. These strips and fine silver are then deftly soldered, carefully avoiding the trellis-like Filigree pattern. Traditional motifs of the flora and fauna are popular; however, the versatility of the art is not restricted by tradition. The art has been extensively extended from jewellery to making other ornate objects. Cuttack in Orissa and Karimnagar in Andhra Pradesh are the key centers of Filigree work in India.", Html.FROM_HTML_MODE_LEGACY));
                } else {
                    flowTextView.setText(Html.fromHtml("Our heritage and artisan communities need to be increasingly relevant for modern society. To this end, Caravan works towards a sophisticated language for Indic crafts. Every Caravan product has a handcrafted element from a traditional Indian craft cluster. To achieve precision and consistent quality, which is the hallmark of Caravan, artisan communities are up-skilled to achieve the level of desired sophistication.<br>Filigree, the exquisite technique of crafting precious metal wires into ornamental designs can be traced back 5000 years to Mesopotamia.  Owing to the common influence and origin, Greek and Indian filigree till date, display similar patterns and processes. <br>This age old, yet contemporary craft involves the silversmith crimping thin strips of fine silver into zig-zag patterns and loops using it to fill up the ground of designs formed by thicker silver strips. These strips and fine silver are then deftly soldered, carefully avoiding the trellis-like Filigree pattern. Traditional motifs of the flora and fauna are popular; however, the versatility of the art is not restricted by tradition. The art has been extensively extended from jewellery to making other ornate objects. Cuttack in Orissa and Karimnagar in Andhra Pradesh are the key centers of Filigree work in India."));
                }
                try {
                    Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "RobotoRegular.ttf");
                    flowTextView.setTypeface(typeface);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                flowTextView.setTextSize(16f);
                view.findViewById(R.id.playButton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putString("VideoUrl", "https://d2w4f1uwlq2g3.cloudfront.net/live/tenant_cdn_content/S1601001/prod_catalog/video/ethnic_wear_500.mp4");
                        bundle.putString("page", "home");
                        VideoDialogFragment videoDialogFragment = VideoDialogFragment.newInstance(bundle);
                        videoDialogFragment.show(getChildFragmentManager(), "Video View Fragment");
                    }
                });
                linearLayout.addView(view);
                break;
            }
            case ONLY_IMAGE: {
                View view = inflater.inflate(R.layout.image_only, container, false);
                view.findViewById(R.id.expand).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("image", R.drawable.banner3);
                        ImageViewFragment imageViewFragment = ImageViewFragment.newInstance(bundle);
                        imageViewFragment.show(getChildFragmentManager(), "Image View Fragment");
                    }
                });
                linearLayout.addView(view);
                break;
            }
            case ONLY_VIDEO: {
                View view = inflater.inflate(R.layout.video_only, container, false);
                view.findViewById(R.id.playButton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putString("VideoUrl", "https://d2w4f1uwlq2g3.cloudfront.net/live/tenant_cdn_content/S1601001/prod_catalog/video/ethnic_wear_500.mp4");
                        bundle.putString("page", "home");
                        VideoDialogFragment videoDialogFragment = VideoDialogFragment.newInstance(bundle);
                        videoDialogFragment.show(getChildFragmentManager(), "Video View Fragment");
                    }
                });
                linearLayout.addView(view);
                break;
            }
        }
    }
}
