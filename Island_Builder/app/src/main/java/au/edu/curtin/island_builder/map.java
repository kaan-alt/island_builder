package au.edu.curtin.island_builder;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class map extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater li, ViewGroup parent, Bundle b)
    {
        View view = li.inflate(R.layout.fragment_map, parent, false);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.map);
        rv.setLayoutManager(new GridLayoutManager(getActivity(), MapData.HEIGHT, GridLayoutManager.HORIZONTAL, false));

        //EVENT HANDLER HERE PLS


        return view;
    }

    private class MapViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView topLeft;
        private ImageView topRight;
        private ImageView botLeft;
        private ImageView botRight;
        private ImageView structureOnTop;


        public MapViewHolder(LayoutInflater li, ViewGroup parent)
        {
            //DOUBLE CHECK grid_cell
            super(li.inflate(R.layout.grid_cell), parent, false);

            topLeft = (ImageView) itemView.findViewById(R.id.topLeft);
            topRight = (ImageView) itemView.findViewById(R.id.topRight);
            botLeft = (ImageView) itemView.findViewById(R.id.botLeft);
            botRight = (ImageView) itemView.findViewById(R.id.botRight);
            structureOnTop = (ImageView) itemView.findViewById(R.id.gridStructure);



            int size = parent.getMeasuredHeight() / MapData.HEIGHT + 1;
            ViewGroup.LayoutParams lp = itemView.getLayoutParams();
            lp.width = size;
            lp.height = size;



        }

        public void bind(MapElement importedMapElement)
        {
            topLeft.setImageResource(importedMapElement.getNorthWest());
            topRight.setImageResource(importedMapElement.getNorthEast());
            botLeft.setImageResource(importedMapElement.getSouthWest());
            botRight.setImageResource(importedMapElement.getSouthEast());
            structureOnTop.setImageResource(importedMapElement.getStructure().getDrawableId());



        }

    }


    public class MapAdapter extends RecyclerView.Adapter<MapViewHolder>
    {
        MapData mapData;

        public MapAdapter(MapData importedMap)
        {
            this.mapData = importedMap;
        }

        @Override
        public int getItemCount()
        {
            return mapData.HEIGHT * mapData.WIDTH;
        }

        @Override
        public MapViewHolder onCreateViewHolder(ViewGroup container, int viewType)
        {
            return new MapViewHolder(LayoutInflater.from(getActivity()), container);
        }

        @Override
        public void onBindViewHolder(@NonNull MapViewHolder mapViewHolder, int i) {
            int row = i % MapData.HEIGHT;
            int col = i / MapData.HEIGHT;
            mapViewHolder.bind(mapData.get(row, col));
        }
    }
}
