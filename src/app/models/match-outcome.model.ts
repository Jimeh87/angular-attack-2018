export interface MatchOutcome {
    optionAId: string,
    optionBId: string,
    result: MatchResult
}

export enum MatchResult {
    OptionA, OptionB, Draw
}