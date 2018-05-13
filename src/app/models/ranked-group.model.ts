import {RankedItem} from "./ranked-item.model";

export interface RankedGroup {
    id: string,
    name: string,
    rankedItems: RankedItem[]
}