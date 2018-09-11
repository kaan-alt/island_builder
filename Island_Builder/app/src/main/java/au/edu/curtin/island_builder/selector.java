package au.edu.curtin.island_builder;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class selector extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selector, container, false);

        //EVENT HANDLER HERE PLS
    }

    private class SelectorViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView selectorStructureImage;
        private TextView selectorStructureText;

        public SelectorViewHolder(LayoutInflater li, ViewGroup parent)
        {
            super(li.inflate(R.layout.list_selection), parent, false);

            selectorStructureImage = (ImageView) itemView.findViewById(R.id.selectorStructureImage);
            selectorStructureText = (TextView) itemView.findViewById(R.id.selectorStructureText);
        }

        public void bind(Structure importedStructure)
        {
            selectorStructureImage.setImageResource(importedStructure.getDrawableId());
            selectorStructureText.setText(importedStructure.getLabel());
        }
    }

    private class SelectorAdapter extends RecyclerView.Adapter<SelectorViewHolder>
    {
        StructureData structureData;

        public SelectorAdapter(StructureData importedStructureData)
        {
            this.structureData = importedStructureData;
        }

        @Override
        public int getItemCount()
        {
            return structureData.size();
        }

        @Override
        public SelectorViewHolder onCreateViewHolder(ViewGroup container, int viewType)
        {
            return new SelectorViewHolder(LayoutInflater.from(getActivity()), container);
        }

        @Override
        public void onBindViewHolder(@NonNull SelectorViewHolder selectorViewHolder, int i)
        {
            selectorViewHolder.bind(structureData.get(i));
        }

    }

}
